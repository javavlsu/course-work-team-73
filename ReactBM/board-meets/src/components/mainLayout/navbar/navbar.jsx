import style from "./navbar.module.css";
import { NavLink, useNavigate } from "react-router-dom";
import { Exit, Logo, Search, User } from "../../icons/icons";
import { getUser } from "../../../helpers/getUser";
import { useState } from "react";
import { useTranslation } from "react-i18next";

export const Navbar = ({ exitHandler }) => {
  const user = getUser();
  const { t } = useTranslation();
  const [search, setSearch] = useState("");
  const navigate = useNavigate();

  let buttonLink = (
    <NavLink to="/logIn" className={style.logInButton}>
      {t("navbar.logIn")}
    </NavLink>
  );

  if (user != "0" && user != undefined) {
    buttonLink = (
      <div className={style.buttons}>
        <NavLink
          to={`user/${user.id}/${user.roles[0].name}`}
          className={style.profileButton}
        >
          <User />
        </NavLink>
        <button
          type="button"
          className={style.exitButton}
          onClick={exitHandler}
        >
          <Exit />
        </button>
      </div>
    );
  }
  return (
    <nav className={style.container}>
      <div className={style.logo}>
        <NavLink to={"/"}>
          <Logo />
        </NavLink>
      </div>

      <div className={style.linkList}>
        <NavLink
          to="/recommendation"
          className={({ isActive }) =>
            isActive ? style.linkActive : style.linkListLink
          }
        >
          {t("navbar.recomendation")}
        </NavLink>
        <NavLink
          to="/"
          className={({ isActive }) =>
            isActive ? style.linkActive : style.linkListLink
          }
        >
          {t("navbar.meets")}
        </NavLink>
        <NavLink
          to="/games"
          className={({ isActive }) =>
            isActive ? style.linkActive : style.linkListLink
          }
        >
          {t("navbar.games")}
        </NavLink>
      </div>

      {buttonLink}
    </nav>
  );
};
