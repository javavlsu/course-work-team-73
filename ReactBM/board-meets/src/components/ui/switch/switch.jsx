import { useState } from "react";
import style from "./switch.module.css";
import { useTranslation } from "react-i18next";
export const Switch = ({ radioHandler }) => {
  const { t } = useTranslation();
  const [check, setCheck] = useState("1");
  const inputHandler = (event) => {
    let value = event.target.value;
    setCheck(value);
    { radioHandler(value) }
  }

  return (
    <div className={style.container}>
      <div className={style.item}>
        <input type="radio" id="radio-1" name="item" value="1" checked={check == 1 ? "checked" : null} onChange={inputHandler}></input>
        <label htmlFor="radio-1">{t("userPage.created")}</label>
      </div>
      <div className={style.item}>
        <input type="radio" id="radio-2" name="item" value="2" checked={check == 2 ? "checked" : null} onChange={inputHandler}></input>
        <label htmlFor="radio-2">{t("userPage.joined")}</label>
      </div>
    </div>
  );
}
