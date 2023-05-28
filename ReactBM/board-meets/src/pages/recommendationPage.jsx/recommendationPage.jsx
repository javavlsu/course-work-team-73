import { GamesList } from "../../components/boardGames/gamesList/gamesList";

export const RecommendationPage = ({ url, userId }) => {
  console.log(url + userId);
  return <GamesList url={url} additionalUrl={`recommendation/${userId}/?`} />;
};
