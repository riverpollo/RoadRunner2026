package org.firstinspires.ftc.teamcode.TeleOp.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.LauncherAndrew;
import org.firstinspires.ftc.teamcode.subsystems.LauncherPower;


@TeleOp(name="DriveTest", group="TeleOpMode")
public class DriveTest extends LinearOpMode {


    private Drive drive;
    private Intake intake;
    private LauncherAndrew LauncherAndrew;


    @Override
    public void runOpMode() {
        //intake = new Intake(hardwareMap, telemetry);
        drive = new Drive(hardwareMap, telemetry);
        //LauncherAndrew = new LauncherAndrew(hardwareMap, telemetry);


        waitForStart();
        while (opModeIsActive()) {
            drive.run(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.right_bumper, -gamepad2.right_stick_x);
            intake.run(gamepad1.a, gamepad1.b, gamepad1.y);
            LauncherAndrew.run(gamepad2.a, gamepad2.b);
            intake.sendTelemetry();
            drive.sendTelemetry();
            LauncherAndrew.sendTelemetry();
            telemetry.update();

            intake = new Intake(hardwareMap, telemetry);


        }
    }
}



