// const { data } = require("autoprefixer");

 function toggleDropdown() {
    document.getElementById("dropdownMenu").classList.toggle("hidden");
  }

  //Default Home pg slider
window.onload = function(){
  const slider = document.getElementById("slider");
  if(slider){
    let currentIndex = 0;
    const slides = slider.children;

    function showSlide(index){
      const slideWidth = slides[0].clientWidth;
      slider.style.transform = `translateX(-${index * slideWidth}px)`;
    }
    function nextSlide(){
      currentIndex = (currentIndex +1) % slides.length;
      showSlide(currentIndex);
    }
    function prevSlide(){
      currentIndex = (currentIndex -1 +slides.length) % slides.length;
      showSlide(currentIndex);
    }
  
    showSlide(currentIndex);
    setInterval(nextSlide,5000);

    document.querySelector("button[onclick='prevSlide()']").onclick = prevSlide;
    document.querySelector("button[onclick='nextSlide()']").onclick = nextSlide;
  } else {
      console.warn("Slider element not found!");
  }
};

// Plan Page image Slider
  var swiper = new Swiper(".mySwiper", {
  loop: true,
  autoplay: {
    delay: 1500,
    disableOnInteraction: false,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  }
});

// Current Location Data fetching
var uLat;
var uLong;

function getLocation(){
  if(navigator.geolocation){
    navigator.geolocation.getCurrentPosition((position) =>{
      uLat = position.coords.latitude;
      uLong = position.coords.longitude;

      document.getElementById("output").innerHTML = "Latitude=" +uLat+ "Longitude="+uLong; 
    }, (error) => {
      alert("Error fetching location: "+error.message);
    });
  }
  else{
    alert("Geolocation is not supported by this browser");
  }
}

// Display Places
function showPlaces(){
  fetch('/searchByLocation',{
    method: 'Post',
    headers: {'Content-Type': 'application/json'},
    body:JSON.stringify({ latitude: uLat,longitude:uLong })
  })
  .then(response => response.json())
  .then(data => {
    let html = '<table><tr><th>Name</th><th>Description</th><th>Budget</th></tr>';
    data.forEach(place => {
      html += `<tr>
                  <td>${place.name}</td>
                  <td>${place.description}</td>
                  <td>${place.budget}</td>
               </tr>`;
    });
    html += '</table>';
    document.getElementById('results').innerHTML = html;
  })
  .catch(err => console.error(err));
}


// Feedback form script
// window.onload = function(){
//   const feedbackSuccess = /*[[${feedbackSuccess}]]*/ false;

//   if(feedbackSuccess){
//     alert("Thank you for your feedback!");
//     setTimeout(function(){
//       window.location.href = "/home-login";
//     }, 2000);
//   }
// }