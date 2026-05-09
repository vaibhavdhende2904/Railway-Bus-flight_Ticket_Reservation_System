const API = "http://localhost:8080/api";

async function searchRoutes(){
    const source = document.getElementById("source").value;
    const destination = document.getElementById("destination").value;

    const response = await fetch(
        `${API}/routes/search?source=${source}&destination=${destination}`
    );

    const data = await response.json();

    let html = "";
    data.forEach(route => {
        html += `
        <div class="route">
            <h3>${route.source} → ${route.destination}</h3>
            <p>Price: ₹${route.price}</p>
            <button onclick="bookRoute(${route.id})">Book</button>
        </div>
        `;
    });

    document.getElementById("results").innerHTML = html;
}

async function bookRoute(routeId){
    const seat = prompt("Enter Seat Number");
    const userId = 1;

    const response = await fetch(`${API}/bookings`,{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            userId:userId,
            routeId:routeId,
            seat:seat,
            date:"2026-05-10"
        })
    });

    const data = await response.json();
    alert("Ticket Booked Successfully. PNR: " + data.pnr);
}