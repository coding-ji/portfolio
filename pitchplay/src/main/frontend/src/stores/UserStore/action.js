import { camelToSnake } from "../../utils/formattedConverter";

// 액션 타입 정의
export const ACTIONS = {
    CHANGE_USER_NUMBER: "CHANGE_USER_NUMBER",
    CHANGE_NAME: "CHANGE_NAME",
    CHANGE_PROFILE_IMG: "CHANGE_PROFILE_IMG",
    CHANGE_BIRTHDAY: "CHANGE_BIRTHDAY",
    CHANGE_EMAIL: "CHANGE_EMAIL",
    CHANGE_PHONE: "CHANGE_PHONE",
    CHANGE_ID: "CHANGE_ID",
    CHANGE_NICKNAME: "CHANGE_NICKNAME",
    CHANGE_PASSWORD: "CHANGE_PASSWORD",
    CHANGE_FAVORITE_CITY: "CHANGE_FAVORITE_CITY",
    CHANGE_FAVORITE_TIME: "CHANGE_FAVORITE_TIME",
    CHANGE_MY_TEAM: "CHANGE_MY_TEAM",
    CHANGE_IS_TEAM_OWNER: "CHANGE_IS_TEAM_OWNER",
    CHANGE_MY_DESCRIPTION: "CHANGE_MY_DESCRIPTION",
    CHANGE_USER_CASH: "CHANGE_USER_CASH",
    CHANGE_ACCOUNT_NAME: "CHANGE_ACCOUNT_NAME",
    CHANGE_ACCOUNT_NUM: "CHANGE_ACCOUNT_NUM",
    CHANGE_JOIN_DATE: "CHANGE_JOIN_DATE",
  };

export const UPDATE_ALL_FIELDS = "UPDATE_ALL_FIELDS";
export const RESET_STATE = "RESET_STATE";

// 동적으로 필드를 변경하는 액션 생성자
export const changeField = (field, value) => ({
  type: `CHANGE_${camelToSnake(field).toUpperCase()}`,
  payload: value
});
export const updateAllFields = (fields) => ({ type: UPDATE_ALL_FIELDS, payload: fields });
export const resetState = () => ({ type: RESET_STATE });