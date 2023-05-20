import { NavLink, useParams } from "react-router-dom";
import { AddButton } from "../../components/ui/addButton/addButton";
import { MeetList } from "../../components/meets/meetList/meetList";
import { Title } from "../../components/ui/title/title";
import { getUser } from "../../helpers/getUser";
import { useCheckAuthorization } from "../../hooks/useCheckAuthorization";
import style from "./organizationPage.module.css";
import { useTranslation } from "react-i18next";

export const OrganizationPage = ({ url }) => {
  const { t } = useTranslation();
  let { userId } = useParams();
  const user = getUser();
  useCheckAuthorization(user?.id, userId);

  return (
    <>
      <div className={style.title}>
        <Title content={t("userPage.createdMeets")} />
      </div>
      <NavLink to={`/user/${userId}/createMeet`}>
        {" "}
        <AddButton />
      </NavLink>
      <MeetList url={url} meetUrl={url + "users/" + userId + "/createdMeet/"} />
    </>
  );
};
