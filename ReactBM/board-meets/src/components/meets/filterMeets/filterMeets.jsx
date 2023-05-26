import { useTranslation } from "react-i18next";
import { CityMeet, Date } from "../../icons/icons";
import style from "./filterMeets.module.css";
export const FilterMeets = ({url, register, searchHandler, handleSubmit}) => {
  const {t} = useTranslation();
  return (
    <form className={style.container} onSubmit={handleSubmit(searchHandler)}>
      <div className={style.inputContainer}>
        <div className={style.inputCity}>
          <label htmlFor="city" className={style.inputIcon}><CityMeet /></label>
          <input type="text" id="city" className={style.inputText} placeholder={t("meetsPage.filter.inputCity")} {...register("city")}/>
        </div>
      </div>
      <button className={style.button}>{t("meetsPage.filter.filterBtn")}</button>
    </form>
  );
}