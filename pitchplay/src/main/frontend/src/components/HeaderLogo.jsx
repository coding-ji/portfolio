import styled from "styled-components";
import soccer from "../assets/logos/pitchplay.svg";
import { Link } from "react-router-dom";

const StyledDiv = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 25px;
    color: #FECACA;
    font-family: 'Lalezar', sans-serif;
    height: 100%;
    width: 100%;
`;

const StyledImg = styled.img`
    filter: drop-shadow(-7px 5px 4px rgba(0, 0, 0, 0.5));
    width: 80px;
    height: 80px; 
`;

const StyledH1 = styled.h1`
    margin: 0;
    display: inline-block;
`;

function HeaderLogo() {
    return (
        <Link to="/">
            <StyledDiv>
                <StyledH1>PITCH</StyledH1>
                <StyledImg src={soccer} alt="PitchPlay logo" />
                <StyledH1>PLAY</StyledH1>
            </StyledDiv>
        </Link>
    );
}

export default HeaderLogo;