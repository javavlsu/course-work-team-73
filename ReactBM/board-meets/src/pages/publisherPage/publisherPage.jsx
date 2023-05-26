import { NavLink, useParams } from "react-router-dom";
import { AddButton } from "../../components/ui/addButton/addButton";
import { GameCard } from "../../components/boardGames/gameCard/gameCard";
import { Title } from "../../components/ui/title/title";
import { getUser } from "../../helpers/getUser";
import { useCheckAuthorization } from "../../hooks/useCheckAuthorization";
import { useDataGet } from "../../hooks/useDataGet";
import style from "./publisherPage.module.css";
import { useTranslation } from "react-i18next";

export const PublisherPage = ({ url }) => {
  const { t } = useTranslation();
  let { userId } = useParams();
  const user = getUser();
  useCheckAuthorization(user?.id, userId);

  const games = useDataGet(`${url}users/${userId}/createdBoardGame`);

  return (
    <>
      <div className={style.titleContainer}>
        <Title content={t("userPage.createdGames")} />
      </div>
      <NavLink to={`/user/${userId}/createGame`}>
        <AddButton />
      </NavLink>
      <ul className={style.gamesList}>
        {!!games?.length &&
          games.map((game) => (
            <li key={game.id} className={style.gamesItem}>
              <GameCard game={game} userId={userId} url={url} />
            </li>
          ))}
      </ul>
    </>
  );
};
