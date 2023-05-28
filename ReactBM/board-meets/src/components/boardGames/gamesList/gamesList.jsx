import { useEffect, useState } from "react";
import { GameCard } from "../gameCard/gameCard";
import style from "./gamesList.module.css";
import { getPageCount, getPagesArray } from "../../../helpers/pages";
import { useDataGet } from "../../../hooks/useDataGet";
import { Pagination } from "../../pagination/pagination";
import { useTranslation } from "react-i18next";

export const GamesList = ({ url, additionalUrl = "" }) => {
  const { t } = useTranslation();
  const [games, setGames] = useState();
  const [totalPages, setTotalPages] = useState(0);
  const [limit, setLimit] = useState(10);
  const [page, setPage] = useState(0);
  const pageArray = getPagesArray(totalPages);

  let gamesList = useDataGet(
    url + `boardGames/${additionalUrl}offset=${page}&limit=${limit}`
  );
  useEffect(() => {
    if (gamesList) {
      for (let game of gamesList.content) {
        switch (game.genre) {
          case "Карточная":
          case "Card game":
            game.genre = t("boardGamesPage.form.selectGenre.cardGame");
            break;
          case "Ролевая":
          case "Roleplay":
            game.genre = t("boardGamesPage.form.selectGenre.roleGame");
            break;
          case "Игра с костями":
          case "Dice game":
            game.genre = t("boardGamesPage.form.selectGenre.diceGame");
            break;
          case "Абстрактная":
          case "Abstract game":
            game.genre = t("boardGamesPage.form.selectGenre.abstractGame");
            break;
          case "Словестная (контакт)":
          case "Verbal (contact)":
            game.genre = t("boardGamesPage.form.selectGenre.verbalGame");
            break;
          case "Бродилка":
          case "Walker game":
            game.genre = t("boardGamesPage.form.selectGenre.walkerGame");
            break;
         
        }
      };
      setGames(gamesList.content);
      setTotalPages(getPageCount(gamesList.totalElements, limit));
    }
  }, [gamesList]);

  const delGame = (game) => {
    setGames(games.filter((elem) => elem.id !== game.id));
  };

  const getNewPage = (page) => {
    setPage(page);
  };
  return (
    <div className={style.container}>
      <ul className={style.gameList}>
        {!!games?.length ? (
          games.map((game) => (
            <li key={game?.id} className={style.gamesItem}>
              <GameCard url={url} game={game} delGame={delGame} />
            </li>
          ))
        ) : (
          <p className={style.notFound}>
            {t("boardGamesPage.boardGamesNotFound")}
          </p>
        )}
      </ul>
      <Pagination page={page} pageArray={pageArray} getNewPage={getNewPage} />
    </div>
  );
};
