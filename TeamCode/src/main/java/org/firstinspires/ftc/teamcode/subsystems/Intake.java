package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@Disabled
public class Intake {

    private DcMotorEx intakeMotor = null;
    private double intakeMaxPower = 1.0;

    private Telemetry telemetry;

    // Construtor recebe o hardwareMap e telemetry do OpMode
    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intake_motor");

    }

    // Executa o intake com base no gatilho
    public void run(boolean a, boolean b, boolean y) {
        if (y){
            inverse();
        }
        if (a) {
            onMotor();
        }
            else if (b) {
                offMotor();


            }
        }



    public void onMotor(){
          intakeMotor.setPower(intakeMaxPower);
    }
    public void offMotor(){
          intakeMotor.setPower(-intakeMaxPower);
    }
    public void inverse(){
        intakeMotor.setPower(0);
    }




    // Telemetria
    public void sendTelemetry() {
        telemetry.addData("Intake Power", intakeMotor.getPower());
    }

    public Action onAuto() {
        return new Action() {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    intakeMotor.setPower(intakeMaxPower);
                    initialized = true;
                }
                return false;
            }
        };
    }
}
