package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
@Autonomous(name="Limelight", group="Robot")
public class Limelight extends OpMode {


    private Limelight3A Limelight;
    private IMU imu;
    private DcMotor teste;

    public void init() {
        Limelight = hardwareMap.get(Limelight3A.class, "limelight");
        teste = hardwareMap.get(DcMotor.class, "motor");
        Limelight.pipelineSwitch(8);
        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));

    }

    public void start() {
        Limelight.start();
    }

    public void loop() {
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        Limelight.updateRobotOrientation(orientation.getYaw());
        LLResult llresout = Limelight.getLatestResult();
        if (llresout != null && llresout.isValid()) {

            Pose3D botpose = llresout.getBotpose();
            telemetry.addData("tx", llresout.getTx());
            telemetry.addData("ty", llresout.getTy());
            telemetry.addData("ta", llresout.getTa());

        if (llresout.getTx() > 1) {

            teste.setPower(1.0);
            }
        else if (llresout.getTx() < -1) {

            teste.setPower(-1.0);
            }
        else if (llresout.getTx() < 1 && llresout.getTx() > -1){

            teste.setPower(0);
            }


        }
    }
}

