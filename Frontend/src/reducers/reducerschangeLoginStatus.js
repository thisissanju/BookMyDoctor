const initialState = false;

export const changeLoginStatus = (state = initialState, action) => {
  switch (action.type) {
    case "LOGIN":
      return !state;
    case "LOGOUT":
      return !state;
    default:
      return state;
  }
};
