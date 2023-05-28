import style from "./moreOptionsGameFilter.module.css";
import {
  Genre,
  Players,
  Сomplexity,
  Rating,
  Publishers,
  Authors,
  SortASC,
  SortDESC,
} from "../../icons/icons";
import { useTranslation } from "react-i18next";

export const MoreOptionsGameFilter = ({ register }) => {
  const { t } = useTranslation();

  return (
    <div className={style.container}>
      <div className={style.optionsContainer}>
        <div className={style.inputsContainer}>
          <div className={style.inputContainer}>
            <Authors fill="#64c661" width="24" height="22" />
            <input
              type="text"
              className={style.input}
              placeholder={t("boardGamesPage.form.inputAuthor.name")}
              {...register("authorsGame")}
            />
          </div>
          <div className={style.inputContainer}>
            <Publishers fill="#64c661" width="24" height="22" />
            <input
              type="text"
              className={style.input}
              placeholder={t("boardGamesPage.form.inputPublisher.name")}
              {...register("publishers")}
            />
          </div>
        </div>
        <div className={style.inputsContainer}>
          <div className={style.inputContainer}>
            <Players fill="#64c661" width="24" height="22" />
            <input
              type="number"
              className={style.inputSecondColumn}
              placeholder="min"
              {...register("rangeOfPlayersMin")}
            />
            <span>до</span>
            <input
              type="number"
              className={style.inputSecondColumn}
              placeholder="max"
              {...register("rangeOfPlayersMax")}
            />
          </div>
          <div className={style.inputContainer}>
            <Сomplexity fill="#64c661" width="24" height="22" />
            <input
              type="number"
              className={style.inputSecondColumn}
              placeholder={t("boardGamesPage.form.inputWeight")}
              {...register("weightGameUser")}
            />
            <Rating fill="#64c661" width="24" height="22" />
            <input
              type="number"
              className={style.inputSecondColumn}
              placeholder={t("boardGamesPage.form.inputRating")}
              {...register("ratingUser")}
            />
          </div>
        </div>
        <div className={style.inputsContainer}>
          <div className={style.selectContainer}>
            <label htmlFor="genre">
              <Genre width="24" height="22" fill="#64c661" />
            </label>
            <select
              className={style.selectGenre}
              name="genre"
              id="genre"
              {...register("genre")}
            >
              <option value="">
                {t("boardGamesPage.form.selectGenre.default")}
              </option>
              <option value={"Карточная"}>
                {t("boardGamesPage.form.selectGenre.cardGame")}
              </option>
              <option value={"Ролевая"}>
                {t("boardGamesPage.form.selectGenre.roleGame")}
              </option>
              <option value={"Игра с костями"}>
                {t("boardGamesPage.form.selectGenre.diceGame")}
              </option>
              <option value={"Абстрактная"}>
                {t("boardGamesPage.form.selectGenre.abstractGame")}
              </option>
              <option value={"Словестная (контакт)"}>
                {t("boardGamesPage.form.selectGenre.verbalGame")}
              </option>
              <option value={"Бродилка"}>
                {t("boardGamesPage.form.selectGenre.walkerGame")}
              </option>
            </select>
          </div>
          <div className={style.selectContainer}>
            <input
              type="checkbox"
              className={style.check}
              id="sortDirection"
              name="sortDirection"
              {...register("sortDirection")}
            />
            <label htmlFor="sortDirection" className={style.labelCheck}>
              <div className={style.check1}>
                <SortASC color="#dbc434" />
              </div>
              <div className={style.check2}>
                <SortDESC color="#dbc434" />
              </div>
            </label>

            <select
              className={style.selectGenre}
              name="sortBy"
              id="sortBy"
              {...register("sortBy")}
            >
              <option value="">
                {t("boardGamesPage.form.selectSortBy.default")}
              </option>
              <option value="ratingUser">
                {t("boardGamesPage.form.selectSortBy.rating")}
              </option>
              <option value="weightGameUser">
                {t("boardGamesPage.form.selectSortBy.weight")}
              </option>
              <option value="agePlayer">
                {t("boardGamesPage.form.selectSortBy.age")}
              </option>
              <option value="gameTime">
                {t("boardGamesPage.form.selectSortBy.gameTime")}
              </option>
            </select>
          </div>
        </div>
      </div>
      <hr />
      <div className={style.buttonContainer}>
        <button className={style.button}>
          {t("boardGamesPage.form.filterBtn")}
        </button>
      </div>
    </div>
  );
};
