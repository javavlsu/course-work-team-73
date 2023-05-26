import { NavLink } from "react-router-dom";
import style from "./registrationSecondStep.module.css";
import { Back } from "../../icons/icons";
import { useTranslation } from "react-i18next";

export const RegistrationSecondStep = ({
  register,
  handleSubmit,
  onSubmit,
  secondStepHandler,
  errors,
  watch,
}) => {
  const { t } = useTranslation();

  return (
    <form className={style.form} onSubmit={handleSubmit(onSubmit)}>
      <p className={style.formTitle}>{t("registrationPage.title")}</p>
      <div className={style.formInput}>
        <label htmlFor="email" className={style.mandatoryLabel}>
          {t("registrationPage.required")}
        </label>
        <input
          type="email"
          id="email"
          className={style.input}
          placeholder=" "
          {...register("email", {
            required: t(
              "registrationPage.secondStepForm.inputEmail.errors.required"
            ),
            pattern: {
              value: /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/,
              message: t(
                "registrationPage.secondStepForm.inputEmail.errors.pattern"
              ),
            },
          })}
        />
        {errors?.email && <p className="error">{errors.email.message}</p>}
        <label className={style.swimLabel} htmlFor="email">
          Email
        </label>
      </div>
      <div className={style.formInput}>
        <label htmlFor="role" className={style.mandatoryLabel}>
          {t("registrationPage.required")}
        </label>
        <select className={style.input} placeholder=" " {...register("role")}>
          <option>player</option>
          <option>organization</option>
          <option>publisher</option>
        </select>
        <label className={style.swimLabel} htmlFor="role">
          {t("registrationPage.secondStepForm.inputRole.title")}
        </label>
      </div>
      <div className={style.formInput}>
        <label htmlFor="password" className={style.mandatoryLabel}>
          {t("registrationPage.required")}
        </label>
        <input
          type="password"
          className={style.input}
          placeholder=" "
          {...register("password", {
            required: t(
              "registrationPage.secondStepForm.inputPassword.errors.required"
            ),
            pattern: {
              value:
                /(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/,
              message: t(
                "registrationPage.secondStepForm.inputPassword.errors.pattern"
              ),
            },
            maxLength: {
              value: 15,
              message: t(
                "registrationPage.secondStepForm.inputPassword.errors.maxLength"
              ),
            },
            minLength: {
              value: 6,
              message: t(
                "registrationPage.secondStepForm.inputPassword.errors.minLength"
              ),
            },
          })}
        />
        {errors?.password && <p className="error">{errors.password.message}</p>}
        <label className={style.swimLabel} htmlFor="password">
          {t("registrationPage.secondStepForm.inputPassword.title")}
        </label>
      </div>
      <div className={style.formInput}>
        <label className={style.mandatoryLabel}>
          {" "}
          {t("registrationPage.required")}
        </label>
        <input
          type="password"
          className={style.input}
          placeholder=" "
          {...register("doublePassword", {
            validate: (val) => {
              if (watch("password") != val) {
                return t(
                  "registrationPage.secondStepForm.inputPassword.errors.watch"
                );
              }
            },
          })}
        />
        {errors?.doublePassword && (
          <p className="error">{errors.doublePassword.message}</p>
        )}
        <label className={style.swimLabel}>
          {t("registrationPage.secondStepForm.inputPassword.returnPass")}
        </label>
      </div>

      <input
        type="submit"
        className={style.formButton}
        value={t("registrationPage.registrationBtn")}
      ></input>
      <div className={style.links}>
        <button
          type="button"
          className={style.backButton}
          onClick={secondStepHandler}
        >
          <Back />
          {t("registrationPage.backBtn")}
        </button>
        <NavLink to="/" className={style.navLink}>
          <Back />
          {t("registrationPage.continueWithoutRegBtn")}
        </NavLink>
      </div>
    </form>
  );
};
