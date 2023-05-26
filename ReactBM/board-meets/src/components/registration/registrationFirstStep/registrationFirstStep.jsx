import { NavLink } from "react-router-dom";
import style from "./registrationFirstStep.module.css";
import { Back } from "../../icons/icons";
import { useTranslation } from "react-i18next";

export const RegistrationFirstStep = ({
  register,
  firstStepHandler,
  handleSubmit,
  errors,
}) => {
  const { t } = useTranslation();

  return (
    <form className={style.form} onSubmit={handleSubmit(firstStepHandler)}>
      <p className={style.formTitle}>{t("registrationPage.title")}</p>
      <div className={style.formInput}>
        <label className={style.mandatoryLabel}>
          {t("registrationPage.required")}
        </label>
        <input
          className={style.input}
          placeholder=" "
          {...register("nickname", {
            required: t(
              "registrationPage.firstStepForm.inputNickname.errors.required"
            ),
            pattern: {
              value: /^([a-zA-z0-9_]{1,23})$/,
              message: t(
                "registrationPage.firstStepForm.inputNickname.errors.pattern"
              ),
            },
            maxLength: {
              value: 15,
              message: t(
                "registrationPage.firstStepForm.inputNickname.errors.maxLength"
              ),
            },
            minLength: {
              value: 3,
              message: t(
                "registrationPage.firstStepForm.inputNickname.errors.minLength"
              ),
            },
          })}
        />
        {errors?.nickname && <p className="error">{errors.nickname.message}</p>}
        <label className={style.swimLabel}>
          {t("registrationPage.firstStepForm.inputNickname.title")}
        </label>
      </div>
      <div className={style.formInput}>
        <label className={style.mandatoryLabel}>
          {t("registrationPage.required")}
        </label>
        <input
          className={style.input}
          placeholder=" "
          {...register("name", {
            required: t(
              "registrationPage.firstStepForm.inputName.errors.required"
            ),
            pattern: {
              value: /^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$/,
              message: t(
                "registrationPage.firstStepForm.inputName.errors.pattern"
              ),
            },
            maxLength: {
              value: 23,
              message: t(
                "registrationPage.firstStepForm.inputName.errors.maxLength"
              ),
            },
            minLength: {
              value: 2,
              message: t(
                "registrationPage.firstStepForm.inputName.errors.minLength"
              ),
            },
          })}
        />
        {errors?.name && <p className="error">{errors.name.message}</p>}
        <label className={style.swimLabel}>
          {t("registrationPage.firstStepForm.inputName.title")}
        </label>
      </div>
      <div className={style.formInput}>
        <label className={style.mandatoryLabel}>
          {t("registrationPage.required")}
        </label>
        <input
          className={style.input}
          placeholder=" "
          {...register("surname", {
            required: t(
              "registrationPage.firstStepForm.inputSurname.errors.required"
            ),
            pattern: {
              value: /^([А-Я]{1}[а-яё]{1,30}|[A-Z]{1}[a-z]{1,30})$/,
              message: t(
                "registrationPage.firstStepForm.inputSurname.errors.pattern"
              ),
            },
            maxLength: {
              value: 30,
              message: t(
                "registrationPage.firstStepForm.inputSurname.errors.maxLength"
              ),
            },
            minLength: {
              value: 2,
              message: t(
                "registrationPage.firstStepForm.inputSurname.errors.minLength"
              ),
            },
          })}
        />
        {errors?.surname && <p className="error">{errors.surname.message}</p>}
        <label className={style.swimLabel}>
          {t("registrationPage.firstStepForm.inputSurname.title")}
        </label>
      </div>
      <div className={style.formInput}>
        <label className={style.mandatoryLabel}>
          {t("registrationPage.required")}
        </label>
        <input
          className={style.input}
          placeholder=" "
          {...register("aboutMe", {
            required: t(
              "registrationPage.firstStepForm.inputAboutMe.errors.required"
            ),
            maxLength: {
              value: 40,
              message: t(
                "registrationPage.firstStepForm.inputAboutMe.errors.maxLength"
              ),
            },
            minLength: {
              value: 3,
              message: t(
                "registrationPage.firstStepForm.inputAboutMe.errors.minLength"
              ),
            },
          })}
        />
        <label className={style.swimLabel}>
          {t("registrationPage.firstStepForm.inputAboutMe.title")}
        </label>
        {errors?.aboutMe && <p className="error">{errors.aboutMe.message}</p>}
      </div>
      <div className={style.formInput}>
        <label className={style.mandatoryLabel}>
          {t("registrationPage.required")}
        </label>
        <input
          className={style.input}
          placeholder=" "
          {...register("city", {
            required: t(
              "registrationPage.firstStepForm.inputCity.errors.required"
            ),
            pattern: {
              value:
                /^([a-zA-Zа-яА-ЯёЁ]+[-]?[a-zA-Zа-яА-ЯёЁ]*[-]?[a-zA-Zа-яА-ЯёЁ]*[-]?[a-zA-Zа-яА-ЯёЁ]*)$/,
              message: t(
                "registrationPage.firstStepForm.inputCity.errors.pattern"
              ),
            },
            maxLength: {
              value: 15,
              message: t(
                "registrationPage.firstStepForm.inputCity.errors.maxLength"
              ),
            },
            minLength: {
              value: 3,
              message: t(
                "registrationPage.firstStepForm.inputCity.errors.minLength"
              ),
            },
          })}
        />
        {errors?.city && <p className="error">{errors.city.message}</p>}
        <label className={style.swimLabel}>
          {t("registrationPage.firstStepForm.inputCity.title")}
        </label>
      </div>
      <input
        type="submit"
        className={style.formButton}
        value={t("registrationPage.continueBtn")}
      ></input>
      <div className={style.links}>
        <NavLink to="/" className={style.navLink}>
          <Back />
          {t("registrationPage.continueWithoutRegBtn")}
        </NavLink>
      </div>
    </form>
  );
};
