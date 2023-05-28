import { useState } from "react";
import { Genre, Options, Game } from "../../icons/icons";
import style from "./filterGames.module.css";
import { MoreOptionsGameFilter } from "../moreOptionsGameFilter/moreOptionsGameFilter";
import { useTranslation } from "react-i18next";
export const FilterGames = ({ register, filterHandler, handleSubmit }) => {
  const [showOptions, setShowOptions] = useState(false);
  const { t } = useTranslation();
  const optionsHandler = () => setShowOptions(!showOptions);
  return (
    <form onSubmit={handleSubmit(filterHandler)}>
      <div className={style.container}>
        <div className={style.inputContainer}>
          <Game color="#ffffff" />
          <input
            type="text"
            className={style.input}
            placeholder={t("boardGamesPage.form.inputName.name")}
            {...register("name")}
          />
        </div>

        <div className={style.btnGroup}>
          <button
            type="button"
            className={style.optionsButton}
            onClick={optionsHandler}
          >
            <Options color={"#64c661"} />
          </button>
          {!showOptions && <button className={style.button}>{t("boardGamesPage.form.filterBtn")}</button>}
        </div>
      </div>
      {showOptions && <MoreOptionsGameFilter register={register} />}
    </form>
  );
};
