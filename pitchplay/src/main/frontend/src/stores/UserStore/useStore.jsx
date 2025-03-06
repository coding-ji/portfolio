import { useReducer } from "react";
import { initialState, reducer } from "./reducer.js";
import { changeField, updateAllFields, resetState } from "./action.js";

export const useStore = () => {
    const [state, dispatch] = useReducer(reducer, initialState);

    const actions = {
        // 필드를 동적으로 변경
        changeField: (field, value) => dispatch(changeField(field, value)),

        // 전체 필드 변경
        updateAllFields: (fields) => dispatch(updateAllFields(fields)),

        // 상태 초기화
        resetState: () => dispatch(resetState())
    };

    return { state, actions };
};