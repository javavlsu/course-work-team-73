import axios from "axios";
import { NavLink } from "react-router-dom";
import { getConfig } from "../../../helpers/getConfig";
import { getUser } from "../../../helpers/getUser";
import {
  Age,
  Close,
  Players,
  Rating,
  TimeBold,
  Сomplexity,
} from "../../icons/icons";
import style from "./comment.module.css";
import { useTranslation } from "react-i18next";

export const Comment = ({ comment, delComment, url }) => {
  const { t } = useTranslation();
  const user = getUser();

  const delHandler = () => {
    axios
      .delete(`${url}comments/${comment.id}`, getConfig())
      .then(() => delComment(comment));
  };

  return (
    <div className={style.container}>
      <div className={style.commentBody}>
        <img
          src={`${url}static/avatar/${comment.author.avatarUrl}`}
          alt="author"
        />
        <NavLink to={comment.author?.id === user.id?`/user/${comment.author?.id}/player`:`/user/${comment.author?.id}`} className={style.author}>
          @{comment.author?.username}
        </NavLink>
        <ul className={style.rating}>
          {user !== "0" && user?.roles[0].name == "admin" ? (
            <button className={style.delButton} onClick={delHandler}>
              <Close width="8" height="8" />
            </button>
          ) : null}
          <li className={style.ratingItem}>
            <span>{comment.rating}</span>
            <Rating />
          </li>
          <li className={style.ratingItem}>
            <span>{comment.weightGame}/5</span>
            <Сomplexity />
          </li>
          <li className={style.ratingItem}>
            <span>
              {comment.bestPlayerMin}-{comment.bestPlayerMax}
            </span>
            <div className={style.bestPalyers}>
              Best
              <Players fill="#057402" />
            </div>
          </li>
          <li className={style.ratingItem}>
            <span>
              {comment.gameTime}
              {t("boardGamesPage.minutes+")}
            </span>
            <TimeBold fill="#057402" />
          </li>
          <li className={style.ratingItem}>
            <span>{comment.agePlayer}+</span>
            <Age fill="#057402" />
          </li>
        </ul>
        <p className={style.text}> {comment.body} </p>
      </div>
    </div>
  );
};
