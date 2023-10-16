const countryDropdown = document.getElementById("countryDropdown");
const searchInput = document.getElementById("searchInput");

function filterCountries() {
    const filterValue = searchInput.value.toLowerCase();
    const options = countryDropdown.options;

    for (let i = 0; i < options.length; i++) {
        const option = options[i];
        const text = option.value.toLowerCase();

        if (text.startsWith(filterValue)) {
            option.style.display = "block";
        } else {
            option.style.display = "none";
        }
    }
}

function resetDropdown() {
    const searchInput = document.getElementById("searchInput");
    searchInput.value = "";
    const options = document.querySelectorAll("#countryDropdown option");
    options.forEach(option => {
        option.style.display = "block";
    });
    document.getElementById("countryDropdown").selectedIndex = 0;
}
