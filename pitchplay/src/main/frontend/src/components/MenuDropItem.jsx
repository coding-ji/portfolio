import { motion } from "framer-motion";
import { Link } from "react-router-dom";

function MenuDropItem({
  children, 
  selectedMenu, 
  index,
  onClick, 
  src, 
  backgroundColor = "rgba(0, 0, 0, 0)",
  selectedBackgroundColor = "rgba(51, 51, 51, 0.5)",
  hoverColor = "#f2f2f2",
  textColor = "#ffffff", 
  hoverTextColor = "#000000",
}) {
  return (
    <Link to={src}>
      <motion.li
        onClick={onClick} // 클릭 시 부모로 전달된 onClick 호출
        style={{
          backgroundColor: selectedMenu === index ? selectedBackgroundColor : backgroundColor,
          color: textColor,
          cursor: "pointer",
        }}
        whileHover={{
          scale: 1.1,
          backgroundColor: hoverColor,
          color: hoverTextColor,
          transition: { duration: 0.3 },
        }}
      >
        {children}
      </motion.li>
    </Link>
  );
}

export default MenuDropItem;



// 사용예제 :
// <MenuDropItem 
//   selectedMenu={selectedMenu}
//   onClick={() => handleClick(index)}
//   index={0}
//   src="/home"
//   backgroundColor="rgba(0, 0, 0, 0.2)"
//   selectedBackgroundColor="rgba(0, 0, 0, 0.6)"
//   hoverColor="#ddd"
//   textColor="#ff6347"
//   hoverTextColor="#fff"
// >
//   텍스트
// </MenuDropItem>