import { Outlet } from "react-router-dom";
import { Footer } from "../../components/mainLayout/footer/footer";
import { Header } from "../../components/mainLayout/header/header";
import { Navbar } from "../../components/mainLayout/navbar/navbar";
import style from "./mainLayout.module.css";

export const MainLayout = ({ exitHandler }) => {
  return (
    <>
      <div className={style.wrap}>
        <Header />
        <div className={style.navbar}>
          <Navbar exitHandler={exitHandler} />
        </div>
        <div className={style.outlet}>
          <Outlet />
        </div>
      </div>
      <Footer />
    </>
  );
}