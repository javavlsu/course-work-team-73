import style from "./header.module.css";
export const Header = () => {

  return (
    <header className={style.container}>
      <div className={style.logo}>
        <p className={style.name}>boardmeets</p>
        <p className={style.tagline}>for your fun)</p>
      </div>
    </header>
  );
};
