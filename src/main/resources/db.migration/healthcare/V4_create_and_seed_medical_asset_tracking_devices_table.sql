-- Migration V4: Creates and seeds the medical_asset_tracking_devices table
-- This table stores device information, including type, quantities, costs, and benefits.

CREATE TABLE medical_asset_tracking_devices (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Unique identifier for each device
    device_type VARCHAR(255) NOT NULL,  -- Type of device (e.g., RFID Tags, Bluetooth Beacons)
    default_quantity INT NOT NULL,      -- Default quantity for this device type
    initial_cost_per_unit DECIMAL(10, 2) NOT NULL,  -- Initial cost per device
    annual_maintenance_cost_per_unit DECIMAL(10, 2) NOT NULL,  -- Annual maintenance cost per device
    increased_sales_benefit_per_unit DECIMAL(10, 2) NOT NULL,  -- Sales benefit per device
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2) NOT NULL,  -- Efficiency cost savings per device
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2) NOT NULL,  -- Customer engagement benefit per device
    device_description TEXT NOT NULL    -- Description of the device
);

-- Insert initial data into the medical_asset_tracking_devices table
INSERT INTO medical_asset_tracking_devices
    (id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit,
    increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit,
    increased_customer_engagement_benefit_per_unit, device_description)
VALUES
    -- RFID Tags: Used for tagging assets to enable easy scanning and real-time tracking
    (1, 'RFID Tags',
        100,  -- Default quantity available
        10,   -- Initial cost per unit
        1,    -- Annual maintenance cost per unit
        500,  -- Sales benefit increase per unit
        500,  -- Cost savings due to efficiency per unit
        200,  -- Benefit from increased customer engagement per unit
        'Useful for tagging all medical assets, allowing for easy scanning and real-time tracking of equipment and devices.'
    ),

    -- Bluetooth Beacons: Devices for tracking asset proximity within a facility
    (2, 'Bluetooth Beacons',
        50,   -- Default quantity
        20,   -- Initial cost per unit
        3,    -- Annual maintenance cost per unit
        400,  -- Sales benefit per unit
        400,  -- Efficiency savings per unit
        150,  -- Engagement benefit per unit
        'Can be attached to devices for proximity tracking within a facility, making it easy to locate assets quickly.'
    ),

    -- Connected Sterilization Equipment: Tracks instruments in the sterilization process
    (3, 'Connected Sterilization Equipment',
        10,    -- Default quantity
        5000,  -- Initial cost per unit
        800,   -- Annual maintenance cost
        1000,  -- Sales benefit per unit
        1000,  -- Efficiency savings per unit
        700,   -- Engagement benefit per unit
        'Ensures that surgical instruments are tracked through the sterilization process for compliance and safety.'
    ),

    -- Inventory Management Systems: Tracks consumables and supplies in the system
    (4, 'Inventory Management Systems',
        3,     -- Default quantity
        3000,  -- Initial cost per unit
        500,   -- Maintenance cost per year
        800,   -- Sales benefit per unit
        800,   -- Efficiency savings per unit
        400,   -- Engagement benefit per unit
        'Tracks consumables and supplies, integrating them into the overall asset management system.'
    ),

    -- Telemedicine Kits: Used for remote consultations, tracked for availability and functionality
    (5, 'Telemedicine Kits',
        5,     -- Default quantity
        2000,  -- Initial cost per unit
        300,   -- Maintenance cost per year
        600,   -- Sales benefit per unit
        600,   -- Efficiency savings per unit
        350,   -- Engagement benefit per unit
        'Devices used for remote consultations, tracked to ensure they are available and functioning correctly.'
    ),

    -- Environmental Monitoring Devices: Monitors conditions in storage areas for equipment safety
    (6, 'Environmental Monitoring Devices',
        0,     -- Default quantity (no initial stock)
        1500,  -- Initial cost per unit
        250,   -- Maintenance cost per year
        700,   -- Sales benefit per unit
        700,   -- Efficiency savings per unit
        500,   -- Engagement benefit per unit
        'Tracks conditions in storage areas to protect sensitive equipment or supplies.'
    );