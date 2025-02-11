import { motion } from "framer-motion";
import { Link } from "react-router-dom";

import DeleteButton from ".DeleteButton";
import TitleText from "./TitleText";
import MenuDropItem from "./MenuDropItem";
import styles from "../styles/MenuDropDown.module.css";

function MenuDropdown({menus, isVisible, handleClose, selectedMenu, handleClick, isLoggedIn}) {
  return (
    <motion.div
      className={styles.menudropgrid}
      initial={{ x: "-120%" }}
      animate={{ x: isVisible ? 0 : "-120%" }}
      transition={{ duration: 0.3, ease: "easeInOut" }}
    >
      {/* 닫기 버튼 */}
      <div className={styles.close}>
        <DeleteButton color="#ffffff" size="medium" onClick={handleClose} />
      </div>

      {/* dropdown 제목 */}
      <div className={styles.title}>
        <TitleText color="var(--pink-color)" size="large">PITCHPLAY</TitleText>
      </div>

      {/* dropdown 아이템 */}
      <ul className={styles.menus}>
        {menus.map((menu, index) => (
          <MenuDropItem
            key={index}
            index={index}
            selectedMenu={selectedMenu}
            onClick={handleClick(index)}
            src={menu.src}
          >
            {menu.name}
          </MenuDropItem>
        ))}
      </ul>

      {/* 로그인 / 로그아웃  링크 */}
      <Link to={isLoggedIn ? "#" : "/login"}>
        <motion.p
          whileHover={{
            color: "#000000",
            transition: { duration: 0.3 },
          }}
          onClick={isLoggedIn ? handleLogout : null}
        >
          {isLoggedIn ? "로그아웃" : "로그인"}
        </motion.p>
      </Link>
    </motion.div>
  );
}

export default MenuDropdown;