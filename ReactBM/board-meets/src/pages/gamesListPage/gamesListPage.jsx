import style from "./gamesListPage.module.css";
import { GamesList } from "../../components/gamesList/gamesList";

export const GamesListPage = ({ url }) => {
  // const { handleSubmit, register } = useForm();
  // const { gameName } = useParams();
  // const navigate = useNavigate();

  // useEffect(
  //   () => {
  //     if (gameName) {
  //       axios.get(url + `BoardGames/Search/${gameName}`)
  //         .then((resp) => { setGames(resp.data) })
  //         .catch((er) => console.log(er))
  //     }
  //   }, [gameName, url])

  // if (!games) {
  //   axios
  //     .get(url + "boardGames/?offset=0&limit=10")
  //     .then((resp) => {
  //       setGames(resp.data.content);
  //     })
  //     .catch((er) => console.log(er));
  // }
  // const searchHandler = (data) => {
  //   if (data.genre == "Все игры") {
  //     setGames(null);
  //     navigate("/games");
  //     return;
  //   };
  //   axios.get(url + `BoardGames/Filter/${data.genre}`, getConfig())
  //     .then((response) => {
  //       setGames(response.data);
  //     })
  //   navigate("/games");
  // }

  return <GamesList url={url} />;
};
