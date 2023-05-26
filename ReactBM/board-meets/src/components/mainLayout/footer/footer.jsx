import { EnFlag, RuFlag } from "../../icons/icons";
import style from "./footer.module.css";
import { useState } from "react";
import { useTranslation } from "react-i18next";
export const Footer = () => {
  const { t, i18n } = useTranslation();
  return (
    <footer className={style.footer}>
      <button
        type="button"
        className={i18n.language === "ru" ? style.flagBtnActive : style.flagBtn}
        onClick={() => {
          i18n.changeLanguage("ru");
        }}
      >
        <RuFlag />
      </button>
      <button
        type="button"
        className={i18n.language === "en" ? style.flagBtnActive : style.flagBtn}
        onClick={() => i18n.changeLanguage("en")}
      >
        <EnFlag />
      </button>
    </footer>
  );
};
