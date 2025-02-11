import styled from "styled-components";

const StyledH1 = styled.h1`
  font-size: ${(props) => {
    switch (props.size) {
      case 'xsmall' : 
        return '1rem';
      case 'small':
        return '1.3rem';
      case 'medium':
        return '1.7rem';
      case 'large':
        return '2rem'; 
      case 'xlarge':
        return '3rem'; 
      default:
        return '1.5rem';
    }
  }};
  color: ${(props) => props.color || "#000000"};
  font-family: 'Poppins', sans-serif;
  font-weight: 700;
  text-align: center;
`;

function TitleText({ color, size, children, gridArea }) {
  return (
    <StyledH1 color={color} size={size} style={{gridArea: gridArea}}>
      {children}
    </StyledH1>
  );
}

export default TitleText;

// 사용 예제: <TitleText color="black" size="large" gridArea="center">텍스트</TitleText>