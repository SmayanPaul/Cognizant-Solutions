import React from "react";

function ListofPlayers({ players }) {
    return (
        <div>
            {players.map((item, index) => (
                <p key={index}>
                    Mr. {item.name} {item.score}
                </p>
            ))}
        </div>
    );
}

export default ListofPlayers;