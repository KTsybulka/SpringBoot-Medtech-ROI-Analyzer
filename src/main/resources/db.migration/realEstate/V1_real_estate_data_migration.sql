-- Create_smart_home_devices_table.sql

CREATE TABLE smart_home_devices (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);


INSERT INTO smart_home_devices (device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
('Robot Vacuums', 10, 400.00, 50.00, 800.00, 100.00, 150.00, 'Automated cleaning devices that keep floors clean with minimal effort.'),
('Smart Bulbs', 20, 25.00, 2.00, 100.00, 20.00, 50.00, 'Energy-efficient bulbs controlled via apps or voice commands.'),
('Learning Thermostats', 5, 300.00, 30.00, 1200.00, 300.00, 200.00, 'Thermostats that learn preferences to optimize energy usage and comfort.'),
('Smart Doorbells', 15, 120.00, 10.00, 300.00, 50.00, 100.00, 'Video-enabled doorbells to monitor visitors and enhance security.'),
('Voice-Controlled Assistants', 0, 150.00, 10.00, 500.00, 150.00, 200.00, 'Assistants like Alexa or Google Assistant to control smart devices and answer questions.');



-- Create_smart_building_devices_table.sql

CREATE TABLE smart_building_devices (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);


INSERT INTO smart_building_devices (device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
('Smart Cameras', 8, 500.00, 40.00, 1200.00, 400.00, 200.00, 'Surveillance cameras for monitoring building security.'),
('Smart Switches and Dimmers', 20, 50.00, 5.00, 200.00, 80.00, 100.00, 'Devices to control and schedule lighting across building spaces.'),
('Smart Vent Systems', 10, 600.00, 50.00, 1500.00, 600.00, 300.00, 'Optimized air circulation systems for efficient HVAC management.'),
('Smart Displays', 5, 800.00, 100.00, 2000.00, 800.00, 600.00, 'Displays for tenant communication and building management.'),
('Smart Lawn Mowers', 0, 2500.00, 300.00, 2500.00, 500.00, 400.00, 'Automated lawn maintenance devices for large outdoor areas.');
