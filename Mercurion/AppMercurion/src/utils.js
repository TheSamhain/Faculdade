/**
 * Calcula a distnacia entre duas cordenadas
 * @param {JSON} coord1 ponto de origem, {latitude, longitude}
 * @param {JSON} coord2 ponto de destino, {latitude, longitude}
 * @returns Distancia entre as duas cordenadas medida em metros
 */
const getDistance = (coord1, coord2) => {
    "use strict";

    if (typeof (coord1) != 'object' || typeof (coord2) != 'object')
        return false;

    if (!coord1.longitude || !coord1.latitude || !coord2.longitude || !coord2.latitude)
        return false;

    const deg2rad = function (deg) {
        return deg * (Math.PI / 180);
    };

    const
        R = 6371,
        dLat = deg2rad(coord2.latitude - coord1.latitude),
        dLng = deg2rad(coord2.longitude - coord1.longitude),
        a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.cos(deg2rad(coord1.latitude))
            * Math.cos(deg2rad(coord1.latitude))
            * Math.sin(dLng / 2) * Math.sin(dLng / 2),
        c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    return Number((R * c * 1000).toFixed());
};

const now = () => {
    let
        today = new Date(),
        dd = String(today.getDate()).padStart(2, '0'),
        mm = String(today.getMonth() + 1).padStart(2, '0'), //January is 0!
        yyyy = today.getFullYear(),
        hh = String(today.getHours()).padStart(2, '0'),
        nn = String(today.getMinutes()).padStart(2, '0'),
        ss = String(today.getSeconds()).padStart(2, '0');

    return `${dd}/${mm}/${yyyy} ${hh}:${nn}:${ss}`;
};

export { getDistance, now };