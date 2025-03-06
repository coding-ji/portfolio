import { ACTIONS, UPDATE_ALL_FIELDS, RESET_STATE } from "./action";
import { snakeToCamel } from "../../utils/formattedConverter";

// 초기값
export const initialState = {
    userNumber: null,
    name: "",
    profileImg: "",
    birthday: "",
    email: "",
    phone: "",
    userId: "",
    nickname: "",
    password: "",
    favoriteCity: "",
    favoriteTime: "",
    myTeam: "",
    isTeamOwner: false,
    myDescription: "",
    userCash: 0,
    account: "",
    accountNum: "",
    joinDate: ""
  };

// 리듀서
export const reducer = (state = initialState, action) => {
    let field = null;
  
    // action.type에서 필드 추출 (CHANGE_ 제외 후 snake_case에서 camelCase로 변환)
    if (action.type.startsWith('CHANGE_')) {
      field = action.type.slice(7); // 'CHANGE_'를 제외한 부분만 추출
      field = snakeToCamel(field);
      console.log(field);
    }
  
    switch (action.type) {
      // 동적으로 필드를 업데이트
      case ACTIONS[action.type]: 
        return { ...state, [field]: action.payload };
  
      case UPDATE_ALL_FIELDS:
        return { ...state, ...action.payload };
  
      case RESET_STATE:
        return initialState;
  
      default:
        return state;
    }
  };