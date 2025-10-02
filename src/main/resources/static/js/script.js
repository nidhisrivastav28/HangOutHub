// const { data } = require("autoprefixer");

function toggleDropdown() {
  document.getElementById("dropdownMenu").classList.toggle("hidden");
}

// Generic Slider
function createSlider(containerId, interval = 3000, slidesToShow = 1) {
    const slider = document.getElementById(containerId);
    if (!slider) return;

    const wrapper = slider.querySelector(".slider-wrapper");
    if (!wrapper) return;

    const slides = wrapper.children;
    let index = 0;

    function showSlide() {
        const offset = -(index * (100 / slidesToShow));
        wrapper.style.transform = `translateX(${offset}%)`;
    }

    function nextSlide() {
        index = (index + 1) % slides.length;
        showSlide();
    }

    setInterval(nextSlide, interval);
}

// ✅ Use generic slider for all
createSlider("homeSlider", 4000, 1);       // login-home result slider
createSlider("slider", 2000, 1);           // default home page image slider
createSlider("feedbackSlider", 3000, 2);   // feedback cards slider
// createSlider("planSlider", 2000, 1);

// For ImgSlider in plan 
function planImgSlider(containerId, interval = 3000) {
  const slider = document.getElementById(containerId);
  const wrapper = slider.querySelector(".slider-wrapper");
  const slides = wrapper.children;
  let index = 0;

  function showSlide() {
    const offset = -(index * slider.clientWidth);
    wrapper.style.transform = `translateX(${offset}px)`;
  }

  function nextSlide() {
    index = (index + 1) % slides.length;
    showSlide();
  }

  // auto slide
  setInterval(nextSlide, interval);

  // resize handle (responsive)
  window.addEventListener("resize", showSlide);
}

planImgSlider("planSlider", 3000);


// Display Places
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            document.getElementById("latitude").value = position.coords.latitude;
            document.getElementById("longitude").value = position.coords.longitude;
        });
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

// Feedback form script
window.onload = function () {
  const feedbackSuccess = /*[[${feedbackSuccess}]]*/ false;

  if (feedbackSuccess) {
    const popup = document.getElementById("thankyouPopup");
    popup.classList.remove("hidden");

    setTimeout(function () {
      window.location.href = "/home-login";
    }, 2000);
  }
}

// Feedback form star Rating
document.addEventListener("DOMContentLoaded", () => {
  // Select all star labels
  const stars = document.querySelectorAll('.star');
  const ratingInput = document.getElementById('ratingInput');
  let selectedStar = 0; // initial value

  // Update stars on page load (if any previous value exists)
  updateStars(selectedStar);

  // Add click event to each star
  stars.forEach((star, i) => {
    star.addEventListener("click", () => {
      selectedStar = i;
      updateStars(i);

      // mark the corresponding hidden radio as checked
      const radio = document.getElementById('star' + (i + 1));
      if (radio) radio.checked = true;

      // store rating for form submission
      ratingInput.value = i + 1;
    });
  });

  // Function to visually update star colors
  function updateStars(index) {
    stars.forEach((star, i) => {
      if (i <= index) {
        star.classList.add("text-yellow-400");
        star.classList.remove("text-gray-300");
      } else {
        star.classList.add("text-gray-300");
        star.classList.remove("text-yellow-400");
      }
    });
  }
});



// Slider for feedback 
// const feedbackSlider = document.getElementById("feedbackSlider");
// const feedbackSlides = feedbackSlider.children;
// let feedbackIndex = 0;

// function getSlidesPerView() {
//   if (window.innerWidth >= 1024) return 4; // large screen
//   if (window.innerWidth >= 768) return 3; // tablet
//   if (window.innerWidth >= 640) return 2; // mobile landscape
//   return 1; // small mobile
// }

// function showFeedbackSlide(index) {
//   if (feedbackSlides.length === 0) return; // safety check
//   const slideWidth = feedbackSlides[0].clientWidth;
//   feedbackSlider.style.transform = `translateX(-${index * slideWidth}px)`;
// }

// function nextFeedbackSlide() {
//   const slidesPerView = getSlidesPerView();
//   const totalSlides = feedbackSlides.length;

//   // Agar totalSlides slidesPerView se kam hai to slide karne ki zarurat nahi
//   if (totalSlides <= slidesPerView) return;

//   feedbackIndex = (feedbackIndex + 1) % (totalSlides - slidesPerView + 1);
//   showFeedbackSlide(feedbackIndex);
// }

// // Start
// showFeedbackSlide(feedbackIndex);
// setInterval(nextFeedbackSlide, 3000);

// // Resize par reset
// window.addEventListener("resize", () => {
//   showFeedbackSlide(feedbackIndex);
// });


// Generic Slider for all pages
// function createSlider(sliderId, interval = 3000) {
//     const sliderContainer = document.getElementById(sliderId);
//     if (!sliderContainer) return;

//     const slider = sliderContainer.querySelector("div.flex"); // inner flex div
//     if (!slider) return;

//     const slides = slider.children;
//     let index = 0;

//     function getSlidesPerView() {
//         if (window.innerWidth >= 1024) return 4;
//         if (window.innerWidth >= 768) return 3;
//         if (window.innerWidth >= 640) return 2;
//         return 1;
//     }

//     function showSlide(i) {
//         if (slides.length === 0) return;
//         const slideWidth = slides[0].clientWidth;
//         slider.style.transform = `translateX(-${i * slideWidth}px)`;
//     }

//     function nextSlide() {
//         const slidesPerView = getSlidesPerView();
//         const totalSlides = slides.length;

//         if (totalSlides <= slidesPerView) return;

//         index = (index + 1) % (totalSlides - slidesPerView + 1);
//         showSlide(index);
//     }

//     showSlide(index);
//     const timer = setInterval(nextSlide, interval);

//     window.addEventListener("resize", () => showSlide(index));

//     return { slider, nextSlide, showSlide, timer };
// }

