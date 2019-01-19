package com.tandari.android.myelectroparts.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.ProjectTable;
import com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.CategoryTable;
import com.tandari.android.myelectroparts.Models.Category;

import java.util.ArrayList;
import java.util.List;

import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_CATEGORIES;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PRODUCT_CLASS;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PRODUCT_SUB_CLASS;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTCATEGORY;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTS;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_NAME;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.VERSION;

public class MyElectroPartBaseHelper extends SQLiteOpenHelper {


    public MyElectroPartBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_PROJECTS);
        db.execSQL(DATABASE_CREATE_CATEGORIES);
        db.execSQL(DATABASE_CREATE_PROJECTCATEGORY);
        db.execSQL(DATABASE_CREATE_PRODUCT_CLASS);
        db.execSQL(DATABASE_CREATE_PRODUCT_SUB_CLASS);

        //Category fill
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Radio');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('MCU and FPGA');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Audio');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Power source');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Model control');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Auto electronic');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Measuring technology');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Robot');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Telephone');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Power electronic');");

        //ProductClass fill
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Passive Components');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Discrate Semiconductors');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Integrate Semiconductors');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Coolers');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Cabels');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('PCBs');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Mechanical Parts');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Connectors and sockets');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Batteries');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Chemicals');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Optoelectronics');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Sensors');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Fuses');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Switch and Buttons');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Tools');");


        //ProductSubClass fill
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Resistors', 1);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Potentiometers', 1);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Capacitors', 1);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Inductors', 1);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Quartz', 1);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Interference filter', 1);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Diodas', 2);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Transistors', 2);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('FETs', 2);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Triaks', 2);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Tiristors', 2);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('IGBTs', 2);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Voltage controlles', 3);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Analog ICs', 3);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Logic ICs', 3);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Processors', 3);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Peripheria IC', 3);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Memories', 3);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Active coolers', 4);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Passive coolers', 4);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Pastes', 4);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Cabels', 5);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Mounted cabels', 5);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Cable accessories', 5);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('PCB plates', 6);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Prototype PCB plates', 6);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Screws and nuts', 7);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Spacers', 7);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Instrument boxes', 7);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Others', 7);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Flat cabels connectors an sockets for PCB', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Audio video connectors', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Pin row and socket for PCB', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('RF connectors', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Bananna connectors', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Communication connectors', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Pressable connectors', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Power network connectors', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Industrial connectors', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Terminal block for PCB', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('DC power supply connectors', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Ferrules and sandals', 8);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Socket for ICs and fuses', 8);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Non-rechargable batteries', 9);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Rechargable batteries', 9);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Cleaning chemical', 10);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Protectors and insulating chemicals', 10);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('PCB creator chemicals', 10);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Soldering aid chemicals', 10);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Soldering tin', 10);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Displays', 11);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Optocouplers', 11);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('LEDS', 11);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Others optos', 11);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Mechanics sensors', 12);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Temperature sensors', 12);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Magnetic field sensors', 12);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Acceleration sensors', 12);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Pressure sensors', 12);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Humidity sensors', 12);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Encoders', 12);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Ultrasonic sensors', 12);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Optical sensors', 12);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Regenerative fuses', 13);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Non-Regenerative fuses', 13);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Press buttons', 14);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Switchs', 14);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Solid State Relay', 14);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Traditional relay', 14);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Reed relay', 14);");

        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Soldering station', 15);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Tools', 15);");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+"("+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME+", "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+") VALUES('Measurement tools', 15);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_PROJECTS);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTS);

        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_CATEGORIES);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_CATEGORIES);

        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_PROJECTCATEGORY);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTCATEGORY);

        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_PRODUCT_CLASS);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_PRODUCT_CLASS);

        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_PRODUCT_SUB_CLASS);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_PRODUCT_SUB_CLASS);


    }


}

