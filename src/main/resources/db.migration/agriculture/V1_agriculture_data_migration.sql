CREATE TABLE smart_farming_devices (
    id INT PRIMARY KEY,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

INSERT INTO smart_farming_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Soil Moisture Sensors', 20, 150, 20, 1000, 600, 400, 'Sensors to monitor soil moisture levels in real-time, helping optimize irrigation.'),
(2, 'Precision Agriculture Drones', 5, 7000, 500, 5000, 2000, 1500, 'Drones equipped with sensors and cameras to monitor crops, map fields, and apply fertilizers precisely.'),
(3, 'Livestock Monitoring Systems', 10, 1200, 100, 3000, 1000, 800, 'Wearable sensors for livestock to monitor health, location, and feeding behavior, reducing losses.'),
(4, 'Automated Irrigation Systems', 8, 2500, 300, 2000, 1200, 900, 'Smart irrigation systems that automatically adjust water usage based on data from weather and soil sensors.'),
(5, 'Crop Disease Detection Cameras', 0, 5000, 700, 4000, 2500, 2000, 'AI-powered cameras to detect early signs of crop diseases, minimizing yield loss.');

CREATE TABLE precision_agriculture_devices (
    id INT PRIMARY KEY,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

INSERT INTO precision_agriculture_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Field Mapping Drones', 10, 8000, 500, 6000, 3000, 2500, 'Drones equipped with advanced imaging sensors to map large fields and analyze soil and crop health.'),
(2, 'Variable Rate Technology (VRT) Systems', 5, 15000, 700, 8000, 5000, 4000, 'Systems for precise application of fertilizers, pesticides, and seeds based on field data.'),
(3, 'Yield Monitoring Sensors', 15, 500, 50, 4000, 2000, 1500, 'Sensors attached to harvesters to monitor and measure crop yields in real time.'),
(4, 'GPS-guided Tractors', 8, 25000, 2000, 10000, 7000, 6000, 'Tractors with GPS-based navigation systems for precise planting, tilling, and harvesting.'),
(5, 'Soil Nutrient Analysis Tools', 0, 3000, 300, 5000, 2500, 2000, 'Devices to analyze soil nutrient levels, helping to create custom fertilizer plans for optimal crop health.');

CREATE TABLE livestock_monitoring_devices (
    id INT PRIMARY KEY,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

INSERT INTO livestock_monitoring_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Wearable Livestock Trackers', 50, 100, 10, 2000, 1000, 500, 'Devices worn by animals to monitor health, location, and activity, helping to improve productivity.'),
(2, 'Automated Feeding Systems', 10, 5000, 300, 4000, 2500, 2000, 'Systems that automatically dispense food based on animal requirements, reducing waste and labor costs.'),
(3, 'Livestock Behavior Monitoring Cameras', 8, 2000, 200, 3000, 1500, 1200, 'AI-powered cameras to monitor animal behavior and detect anomalies like illness or stress.'),
(4, 'Milk Yield Monitoring Systems', 20, 1500, 100, 5000, 2000, 1800, 'Systems to measure milk production in real time, helping optimize dairy farm operations.'),
(5, 'Automated Calving Sensors', 0, 1200, 50, 2000, 1000, 800, 'Sensors to monitor pregnant livestock and provide alerts during calving for timely assistance.');

CREATE TABLE smart_irrigation_devices (
    id INT PRIMARY KEY,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

INSERT INTO smart_irrigation_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Soil Moisture Sensors', 50, 150, 20, 1500, 800, 600, 'Sensors to monitor soil moisture levels in real time, helping optimize irrigation and water usage.'),
(2, 'Weather Monitoring Stations', 5, 3000, 200, 4000, 2500, 2000, 'Stations to collect weather data like rainfall, temperature, and humidity for better irrigation planning.'),
(3, 'Drip Irrigation Systems', 15, 1000, 50, 3000, 1500, 1000, 'Efficient irrigation systems delivering water directly to plant roots, reducing wastage.'),
(4, 'Automated Irrigation Controllers', 10, 2000, 100, 5000, 3000, 2500, 'Controllers that automate irrigation schedules based on weather and soil data, improving efficiency.'),
(5, 'Smart Sprinkler Systems', 0, 1200, 50, 2000, 1000, 800, 'Sprinklers that use AI to adjust water flow based on field-specific needs, reducing water wastage.');

CREATE TABLE crop_disease_detection_devices (
    id INT PRIMARY KEY,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

INSERT INTO crop_disease_detection_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'AI-powered Disease Detection Cameras', 5, 8000, 500, 5000, 2500, 2000, 'Cameras with AI capabilities to detect crop diseases early through image analysis.'),
(2, 'Mobile Disease Diagnostic Apps', 20, 200, 10, 1500, 1000, 800, 'Mobile apps integrated with AI to analyze photos of crops and diagnose diseases instantly.'),
(3, 'Sensor-based Disease Detection Systems', 10, 5000, 300, 4000, 2000, 1500, 'Sensors to measure environmental factors and detect conditions favorable for disease outbreaks.'),
(4, 'Drones with Multi-spectral Imaging', 5, 12000, 800, 7000, 4000, 3000, 'Drones equipped with multi-spectral cameras to identify crop stress and disease patterns.'),
(5, 'Smart Crop Disease Alerts System', 0, 3000, 200, 3000, 1500, 1000, 'Systems that provide real-time disease alerts based on environmental data and historical trends.');


CREATE TABLE smart_greenhouse_devices (
    id INT PRIMARY KEY,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

INSERT INTO smart_greenhouse_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Automated Climate Control Systems', 8, 10000, 500, 8000, 4000, 3000, 'Systems to automatically adjust temperature, humidity, and ventilation for optimal growing conditions.'),
(2, 'Smart Irrigation Systems', 10, 3000, 200, 5000, 2500, 2000, 'Irrigation systems that adjust water usage based on real-time data from sensors.'),
(3, 'CO2 Enrichment Systems', 5, 7000, 300, 6000, 3000, 2500, 'Systems that inject CO2 into the greenhouse to promote faster plant growth.'),
(4, 'Multi-spectral LED Grow Lights', 15, 2000, 100, 4000, 2000, 1500, 'Energy-efficient lights that provide optimized light wavelengths for plant growth.'),
(5, 'AI-driven Greenhouse Management Platforms', 0, 15000, 1000, 9000, 5000, 4000, 'Platforms using AI to monitor and control all greenhouse operations from a single interface.');
