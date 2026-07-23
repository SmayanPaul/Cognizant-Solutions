import React from "react";

function Scorebelow70({ players }) {
    const players70 = players.filter(item => item.score <= 70);

    return (
        <div>
            {players70.map((item, index) => (
                <p key={index}>
                    Mr. {item.name} {item.score}
                </p>
            ))}
        </div>
    );
}

export default Scorebelow70;