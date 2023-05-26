import Cookies from 'universal-cookie';
export const getConfig = () => {
  let cookies = new Cookies();
  let token = "_" + cookies.get('token');
  return ({ headers: { Authorization: `Bearer${token}` } });
};
