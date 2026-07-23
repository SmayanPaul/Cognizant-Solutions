import React from "react";

function OddPlayers([first, third, fifth]) {
    return (
        <div>
            <p>First : {first}</p>
            <p>Third : {third}</p>
            <p>Fifth : {fifth}</p>
        </div>
    );
}

function EvenPlayers([second, fourth, sixth]) {
    return (
        <div>
            <p>Second : {second}</p>
            <p>Fourth : {fourth}</p>
            <p>Sixth : {sixth}</p>
        </div>
    );
}

const T20Players = [
    "First Player",
    "Second Player",
    "Third Player"
];

const RanjiPlayers = [
    "Fourth Player",
    "Fifth Player",
    "Sixth Player"
];

const IndianPlayers = [...T20Players, ...RanjiPlayers];

function ListofIndianPlayers({ IndianPlayers }) {
    return (
        <div>
            {IndianPlayers.map((player, index) => (
                <p key={index}>Mr. {player}</p>
            ))}
        </div>
    );
}

export {
    OddPlayers,
    EvenPlayers,
    IndianPlayers,
    ListofIndianPlayers
};