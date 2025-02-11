import { Link } from "react-router-dom";
import styles from "../styles/Header.module.css";

import HeaderLogo from "./HeaderLogo";
import TitleText from "./TitleText";

import mypage from "../aassets/mypage.svg";
import search from "../aassets/search.svg";
import setting from "../aassets/setting.svg";
import menu from "../aassets/menu.svg";

function Header({ openMenu, user, openModal, handleAdminClick}) {
    return (
        <div className={styles["header-container"]} style={{ gridArea: "header" }}>
            {/* 왼쪽 메뉴 */}
            <div className={styles["header-left"]}>
                <div onClick={openMenu} className={styles["header-menu"]}>
                    <img src={menu} />
                    <TitleText color="white">MENU</TitleText>
                </div>
            </div>

            {/* 중간 로고 */}
            <div className={styles["header-middle"]}>
                <HeaderLogo />
            </div>

            {/* 오른쪽 메뉴 */}
            <ul className={styles["header-right"]}>
                {/* 마이페이지 링크 */}
                <Link to={user ? `/mypage/${user.id}` : `/login`}>
                    <img src={mypage} />
                </Link>

                {/* 검색 버튼 */}
                <Link to="#" onClick={openModal}>
                    <img src={search} />
                </Link>

                {/* 관리자 페이지 링크 */}
                <Link to="/admin" onClick={handleAdminClick}>
                    <img src={setting} />
                </Link>
            </ul>
        </div>
    )
}

export default Header;