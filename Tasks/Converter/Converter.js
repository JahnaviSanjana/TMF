const conversionFactors = {
    length: {
      meters: {
        centimeters: (value) => value * 100,
        inches: (value) => value * 39.37
      },
      centimeters: {
        meters: (value) => value / 100,
        inches: (value) => value / 2.54
      },
      inches: {
        meters: (value) => value / 39.37,
        centimeters: (value) => value * 2.54
      }
    },
    time: {
      seconds: {
        minutes: (value) => value / 60,
        hours: (value) => value / 3600
      },
      minutes: {
        seconds: (value) => value * 60,
        hours: (value) => value / 60
      },
      hours: {
        seconds: (value) => value * 3600,
        minutes: (value) => value * 60
      }
    },
    temperature: {
      celsius: {
        fahrenheit: (value) => (value * 9/5) + 32,
        kelvin: (value) => value + 273.15
      },
      fahrenheit: {
        celsius: (value) => (value - 32) * 5/9,
        kelvin: (value) => (value - 32) * 5/9 + 273.15
      },
      kelvin: {
        celsius: (value) => value - 273.15,
        fahrenheit: (value) => (value - 273.15) * 9/5 + 32
      }
    },
    speed: {
      meters_per_second: {
        kilometers_per_hour: (value) => value * 3.6,
        miles_per_hour: (value) => value * 2.23694
      },
      kilometers_per_hour: {
        meters_per_second: (value) => value / 3.6,
        miles_per_hour: (value) => value / 1.60934
      },
      miles_per_hour: {
        meters_per_second: (value) => value / 2.23694,
        kilometers_per_hour: (value) => value * 1.60934
      }
    },
    weight: {
      kilograms: {
        grams: (value) => value * 1000,
        pounds: (value) => value * 2.20462
      },
      grams: {
        kilograms: (value) => value / 1000,
        pounds: (value) => value / 453.592
      },
      pounds: {
        kilograms: (value) => value / 2.20462,
        grams: (value) => value * 453.592
      }
    },
    energy: {
      joules: {
        calories: (value) => value / 4.184,
        electronvolts: (value) => value * 6.242e12
      },
      calories: {
        joules: (value) => value * 4.184,
        electronvolts: (value) => value * 2.613e19
      },
      electronvolts: {
        joules: (value) => value * 1.602e-19,
        calories: (value) => value * 3.829e-20
      }
    }
  };
  
  function updateUnits() {
    const category = document.getElementById('category').value;
    const fromUnitSelect = document.getElementById('fromUnit');
    const toUnitSelect = document.getElementById('toUnit');
  
    fromUnitSelect.innerHTML = '';
    toUnitSelect.innerHTML = '';
  
    const units = Object.keys(conversionFactors[category]);
  
    units.forEach(unit => {
      const fromOption = document.createElement('option');
      fromOption.value = unit;
      fromOption.textContent = unit;
      fromUnitSelect.appendChild(fromOption);
  
      const toOption = document.createElement('option');
      toOption.value = unit;
      toOption.textContent = unit;
      toUnitSelect.appendChild(toOption);
    });
  }
  
  function convert() {
    const inputQuantity = parseFloat(document.getElementById('inputQuantity').value);
    const fromUnit = document.getElementById('fromUnit').value;
    const toUnit = document.getElementById('toUnit').value;
    const result = document.getElementById('result');
  
    if (isNaN(inputQuantity)) {
      result.innerHTML = 'Please enter a valid number.';
      return;
    }
  
    const category = document.getElementById('category').value;
  
    if (!conversionFactors.hasOwnProperty(category) ||
        !conversionFactors[category][fromUnit] ||
        !conversionFactors[category][fromUnit][toUnit]) {
      result.innerHTML = 'Invalid units selected for conversion.';
      return;
    }
  
    const conversionFunction = conversionFactors[category][fromUnit][toUnit];
    const convertedValue = conversionFunction(inputQuantity);
  
    result.innerHTML = `${inputQuantity} ${fromUnit} is equal to ${convertedValue} ${toUnit}`;
  }
  
  updateUnits(); // Initially populate the 'fromUnit' and 'toUnit' select options
  