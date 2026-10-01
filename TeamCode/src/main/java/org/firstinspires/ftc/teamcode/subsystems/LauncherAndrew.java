package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LauncherAndrew {

    private final DcMotorEx launcherMotorOne;
    private final DcMotorEx launcherMotorTwo;
    private final DcMotorEx indexMotor;

    private final ElapsedTime indexTimer = new ElapsedTime();

    private final Telemetry telemetry;


    // Construtor recebe o hardwareMap e telemetry do OpMode
    public LauncherAndrew(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        launcherMotorOne = hardwareMap.get(DcMotorEx.class, "launcher_motor_one");
        launcherMotorTwo = hardwareMap.get(DcMotorEx.class, "launcher_motor_two");
        launcherMotorOne.setDirection(DcMotorSimple.Direction.FORWARD);
        indexMotor = hardwareMap.get(DcMotorEx.class, "index_motor");
        indexMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    // Executa o launcher
    public void run(boolean on, boolean off) {


        if (on) {
            onMotor();
        } else if (off) {
            offMotor();


        }
    }

    public void onMotor() {
        launcherMotorOne.setPower(1);

        launcherMotorTwo.setPower(1);
    }

    public void offMotor() {
        launcherMotorOne.setPower(0);
        launcherMotorTwo.setPower(0);

    }


    public void sendTelemetry() {
        telemetry.addData(" Laucher direito", launcherMotorOne);
        telemetry.addData("Laucher esquerdo", launcherMotorTwo);
    }
}

