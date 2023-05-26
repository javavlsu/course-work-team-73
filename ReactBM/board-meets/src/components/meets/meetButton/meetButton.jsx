import axios from "axios";
import { getConfig } from "../../../helpers/getConfig";
import style from "./meetButton.module.css";
import { getUser } from "../../../helpers/getUser";
import { useContext } from "react";
import { MeetsContext } from "../../../helpers/meetsContext";
import { useTranslation } from "react-i18next";

export const MeetButton = ({ meet, url }) => {
  const user = getUser();
  const {t} = useTranslation();
  const { deleteMeet, changeMeet, userPage } = useContext(MeetsContext);
  const userId = user === "0" ? null : parseInt(user?.id);
  let typeMeet = userId != null ? "NotJoined" : null;
  let playersIdList =
    meet.players.length && meet.players.map((player) => player?.id);

  if (playersIdList && playersIdList.includes(userId)) {
    typeMeet = "Joined";
  }

  switch (meet.state) {
    case "RECRUITINGFULL":
    case "FINISHED":
    case "RECRUITING": {
      if (
        userId &&
        (userId == meet.authorId || user?.roles[0].name == "admin")
      ) {
        typeMeet = "Created";
      }
      break;
    }
    case "STARTOPEN": {
      if (userId == meet.authorId) {
        typeMeet = "StartOpen";
      }
      break;
    }
    case "STARTLOCK": {
      if (userId == meet.authorId) {
        typeMeet = "StartLock";
      }
      break;
    }
    case "STARTFULL":
      typeMeet = null;
      break;
  }

  const leaveHander = () => {
    axios
      .put(url + `meets/${meet.id}/exitUser/${userId}`, {}, getConfig())
      .then((resp) => {
        console.log(resp.data);
        changeMeet(resp.data);
      });
  };

  const deleteHander = () => {
    axios
      .delete(url + `meets/${meet.id}`, getConfig())
      .then(() => deleteMeet(meet));
  };
  const joinHander = () => {
    axios
      .put(url + `meets/${meet.id}/joinUser/${userId}`, {}, getConfig())
      .then((resp) => changeMeet(resp.data));
  };
  const closeHander = () => {
    axios
      .put(url + `meets/${meet.id}/lock`, {}, getConfig())
      .then((resp) => (userPage ? changeMeet(resp.data) : deleteMeet(meet)));
  };
  const openHander = () => {
    axios
      .put(url + `meets/${meet.id}/open`, {}, getConfig())
      .then((resp) => changeMeet(resp.data));
  };

  switch (typeMeet) {
    case "Joined":
      return (
        <input
          type="button"
          className={style.meetButton}
          value={t("meetsPage.meet.meetButton.leave")}
          onClick={leaveHander}
        />
      );
    case "Created":
      return (
        <input
          type="button"
          className={style.meetButton}
          value={t("meetsPage.meet.meetButton.delete")}
          onClick={deleteHander}
        />
      );
    case "StartOpen":
      return (
        <input
          type="button"
          className={style.meetButton}
          value={t("meetsPage.meet.meetButton.closeSet")}
          onClick={closeHander}
        />
      );
    case "StartLock":
      return (
        <input
          type="button"
          className={style.meetButton}
          value={t("meetsPage.meet.meetButton.openSet")}
          onClick={openHander}
        />
      );
    case "NotJoined":
      return user?.roles[0].name == "player" ? (
        <input
          type="button"
          className={style.meetButton}
          value={t("meetsPage.meet.meetButton.join")}
          onClick={joinHander}
        />
      ) : null;
  }
};
