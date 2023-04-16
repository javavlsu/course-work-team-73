import { useEffect, useState } from "react";
import { GameCard } from "../gameCard/gameCard";
import style from "./gamesList.module.css";
import { getPageCount, getPagesArray } from "../../helpers/pages";
import { useDataGet } from "../../hooks/useDataGet";
import { Pagination } from "../pagination/pagination";

export const GamesList = ({ url, additionalUrl = "" }) => {
  const [games, setGames] = useState();
  const [totalPages, setTotalPages] = useState(0);
  const [limit, setLimit] = useState(1);
  const [page, setPage] = useState(0);
  const pageArray = getPagesArray(totalPages);

  let gamesList = useDataGet(
    url + `boardGames/${additionalUrl}?offset=${page}&limit=${limit}`
  );

  useEffect(() => {
    if (gamesList) {
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
          <p className={style.notFound}>Игры не найдены 👽</p>
        )}
      </ul>
      <Pagination page={page} pageArray={pageArray} getNewPage={getNewPage} />
    </div>
  );
};
