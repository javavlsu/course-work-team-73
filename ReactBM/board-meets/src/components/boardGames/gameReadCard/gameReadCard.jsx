import { GameMainInfo } from "../gameMainInfo/gameMainInfo";
import { Age, Players, Rating, TimeBold, Сomplexity } from "../../icons/icons";
import style from "./gameReadCard.module.css";
import { useTranslation } from "react-i18next";

export const GameReadCard = ({ game, url }) => {
  const { t } = useTranslation();
  return (
    <div className={style.container}>
      <GameMainInfo game={game} url={url} />
      <div className={style.moreInfo}>
        <div className={style.infoBlock}>
          <p className={style.author}>@{game?.author.username}</p>
          <div className={style.rating}>
            <Rating />
            {game?.ratingUser}
          </div>
          <div className={style.community}>
            <p>Community</p>
            <div className={style.infoList}>
              <div className={style.infoItemBlock}>
                <div className={style.infoItem}>
                  <span>Best</span>
                  <Players fill="#057402" />
                  <p className={style.gameItemInfo}>
                    {game?.bestRangeOfPlayersMinUser}-
                    {game?.bestRangeOfPlayersMaxUser}
                  </p>
                </div>
                <div className={style.infoItem}>
                  <TimeBold fill="#057402" />
                  <p className={style.gameItemInfo}>
                    {game?.gameTimeUser}
                    {t("boardGamesPage.minutes+")}
                  </p>
                </div>
              </div>
              <div className={style.infoItemBlock}>
                <div className={style.infoItem}>
                  <Сomplexity />
                  <p className={style.gameItemInfo}>{game?.weightGameUser}/5</p>
                </div>
                <div className={style.infoItem}>
                  <Age fill="#057402" />
                  <p className={style.gameItemInfo}>{game?.agePlayerUser}+</p>
                </div>
              </div>
            </div>
          </div>
          <div className={style.verticalLine}></div>
          <div className={style.creators}>
            <ul className={style.creatorsList}>
              <li className={style.creatorsItem}>
                <p>
                  {t("boardGamesPage.gameCard.authors")}{" "}
                  <span>{game?.authorsGame}</span>
                </p>
              </li>
              <li className={style.creatorsItem}>
                <p>
                  {t("boardGamesPage.gameCard.artists")}{" "}
                  <span>{game?.artists}</span>
                </p>
              </li>
              <li className={style.creatorsItem}>
                <p>
                  {t("boardGamesPage.gameCard.publishers")}{" "}
                  <span>{game?.publishers}</span>
                </p>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
};
