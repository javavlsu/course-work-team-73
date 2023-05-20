import style from "./meetMoreInfo.module.css";
import { Change, Communication, LightMaxTime, Participants } from "../../icons/icons";
import { NavLink } from "react-router-dom";
import { MeetButton } from "../meetButton/meetButton";
import { getUser } from "../../../helpers/getUser";
import { useTranslation } from "react-i18next";

export const MeetMoreInfo = ({ meet, url}) => {
  const user = getUser();
  const {t} = useTranslation();
  let playersIdList = meet.players.length && meet.players.map((player) => player.id);
  let linkChange = null;
  let gameList = JSON.parse(meet.games);

  if (user?.id == meet.authorId) {
    linkChange = <NavLink to={`/user/${meet.authorId}/changeMeet/${meet.id}`} className={style.linkChange}><Change /></NavLink>
  }

  return (
    <section className={style.moreInfo}>
      {linkChange}
      <ul className={style.otherInfoList}>
        <li className={style.infoItem}>
          <Participants />
          <p className={style.otherInfoText}>{meet.peopleCount}/{meet.peopleCountMax}</p>
        </li>
        <li className={style.infoItem}>
          <LightMaxTime />
          <p className={style.otherInfoText}>{Math.trunc(meet.duration/60)} {t("meetsPage.meet.hour")} {meet.duration%60} {t("meetsPage.meet.minute")}</p>
        </li>
        <li className={style.infoItem}>
          <Communication />
          <p className={style.otherInfoText}>{meet.link ? meet.link : t("meetsPage.meet.notFoundLink")}</p>
        </li>
      </ul>
      <div className={style.horisontLine} />
      <ul className={style.gamesList}>
        <li className={style.infoItem}> <p className={style.infoTitle}>{t("meetsPage.meet.games")}</p></li>
        {gameList?.length && gameList.map((game) =>
          <li key={game} className={style.gamesListItem}>{game}</li>
        )}
      </ul>
      <div className={style.horisontLine} />
      <ul className={style.otherInfoList}>
        <li className={style.infoItem}> <p className={style.infoTitle}>{t("meetsPage.meet.members")}</p></li>
        {meet.players.length ? meet.players.map((player) =>
          <li className={style.infoItem} key={player?.id}><NavLink to={(player.id==user?.id) ? `/user/${player.id}/${user.roles[0].name}` : `/user/${player.id}`}>@{player.username}</NavLink></li>
        ) : <li className={style.infoItem}>{t("meetsPage.meet.notFoundMembers")}</li>}
      </ul>
      <MeetButton meet={meet} url={url}/>
    </section>
  );
}
