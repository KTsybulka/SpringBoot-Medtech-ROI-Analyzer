-- Create Table: Smart Store Devices
CREATE TABLE IF NOT EXISTS smart_store_devices (
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

-- Insert Data: Smart Store Devices
INSERT INTO smart_store_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Smart Shelves', 10, 2000, 300, 1500, 800, 1000, 'Equipped with sensors to track inventory levels in real-time and reduce stockouts.'),
(2, 'IoT Beacons', 15, 500, 80, 1000, 400, 600, 'Provide personalized offers and navigation within the store through customer smartphones.'),
(3, 'Facial Recognition Systems', 5, 3000, 500, 2000, 1200, 800, 'Identify loyal customers and enhance in-store experiences through personalized recommendations.'),
(4, 'Automated Checkout Systems', 3, 10000, 1200, 5000, 3000, 2000, 'Enable seamless checkout with cameras and sensors, improving efficiency.'),
(5, 'Smart Lighting and HVAC', 0, 1500, 200, 800, 500, 300, 'Adjust lighting and temperature automatically based on traffic and time of day.');

-- Create Table: Smart Delivery Devices
CREATE TABLE IF NOT EXISTS smart_delivery_devices (
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

-- Insert Data: Smart Delivery Devices
INSERT INTO smart_delivery_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Delivery Drones', 5, 12000, 1500, 6000, 3000, 2000, 'Facilitate fast, contactless delivery for lightweight packages.'),
(2, 'Autonomous Delivery Vehicles', 3, 30000, 4000, 10000, 5000, 3000, 'Optimize last-mile delivery with AI-driven navigation systems.'),
(3, 'GPS Tracking Devices', 20, 200, 50, 1500, 1000, 800, 'Provide real-time updates to customers and businesses on delivery status.'),
(4, 'Smart Lockers', 6, 2000, 300, 1000, 700, 500, 'Secure delivery points for package collection, reducing missed deliveries.'),
(5, 'IoT Sensors for Delivery Vehicles', 0, 250, 50, 800, 400, 300, 'Monitor vehicle conditions and ensure optimal delivery routes.');

-- Repeat the process for other tables and data

-- Create Table: Smart Logistics Devices
CREATE TABLE IF NOT EXISTS smart_logistics_devices (
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

-- Insert Data: Smart Logistics Devices
INSERT INTO smart_logistics_devices
(id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'RFID Tags', 100, 5, 0.5, 1000, 800, 400, 'Enable real-time tracking of shipments, reducing inventory inaccuracies.'),
(2, 'Warehouse Robots', 8, 25000, 3000, 12000, 7000, 4000, 'Automate sorting, packing, and moving inventory to streamline warehouse operations.'),
(3, 'IoT-enabled Fleet Management Systems', 5, 1200, 200, 3000, 2000, 1500, 'Monitor vehicle locations, fuel usage, and driver behavior.'),
(4, 'Temperature Sensors', 10, 300, 40, 1200, 800, 600, 'Ensure proper conditions for sensitive goods like perishables or medicines.'),
(5, 'Predictive Analytics Platforms', 0, 5000, 700, 4000, 2500, 2000, 'Forecast demand and optimize logistics planning.');


-- Smart Inventory Management
CREATE TABLE smart_inventory_management_devices (
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

INSERT INTO smart_inventory_management_devices (id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Automated Stock Replenishment Systems', 10, 3000, 500, 2000, 1500, 1000, 'Trigger purchase orders automatically when stock reaches a critical level.'),
(2, 'IoT Sensors for Real-time Monitoring', 20, 200, 40, 1500, 800, 600, 'Track stock levels in real-time and alert for discrepancies.'),
(3, 'AI-driven Demand Forecasting Tools', 5, 8000, 1000, 4000, 2500, 2000, 'Predict sales trends to prevent overstocking or understocking.'),
(4, 'Smart Barcode Scanners', 15, 150, 10, 600, 400, 300, 'Speed up inventory audits and improve accuracy.'),
(5, 'Cloud-based Inventory Platforms', 0, 2500, 300, 1200, 900, 700, 'Provide real-time access to inventory data across multiple locations.');


-- 5. Smart Customer Analytics
CREATE TABLE smart_customer_analytics_devices (
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
INSERT INTO smart_customer_analytics_devices (id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'In-store Cameras with AI', 10, 3000, 400, 2000, 1500, 1200, 'Analyze customer foot traffic and shopping patterns to optimize store layout.'),
(2, 'Smart POS Systems', 8, 2500, 300, 1500, 1000, 900, 'Collect and analyze transactional data for customer insights.'),
(3, 'Heatmaps and Footfall Sensors', 12, 1500, 200, 1000, 800, 600, 'Identify popular areas in the store and optimize layouts accordingly.'),
(4, 'Customer Feedback Kiosks', 6, 1200, 150, 800, 600, 500, 'Gather real-time feedback on products and services directly from customers.'),
(5, 'AI-powered Recommendation Engines', 0, 8000, 1000, 5000, 3000, 2500, 'Suggest products based on purchase history and customer preferences.');


-- 6. Smart Pricing
CREATE TABLE smart_pricing_devices (
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

INSERT INTO smart_pricing_devices (id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
(1, 'Dynamic Pricing Software', 3, 10000, 1500, 5000, 3000, 2500, 'Adjust prices in real-time based on demand and competition.'),
(2, 'Electronic Shelf Labels', 15, 200, 20, 800, 600, 500, 'Update prices automatically on shelves without manual intervention.'),
(3, 'AI-based Competitive Analysis Tools', 5, 7000, 1200, 4000, 2500, 2000, 'Monitor competitors’ pricing to stay competitive in the market.'),
(4, 'Predictive Analytics Platforms', 4, 9000, 1000, 6000, 4000, 3000, 'Forecast the best pricing strategies based on market trends.'),
(5, 'Customer Sentiment Analysis Tools', 0, 4000, 500, 3000, 2000, 1500, 'Understand customer reactions to pricing changes via social media and reviews.');

