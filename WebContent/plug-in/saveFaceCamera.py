import cv2
import face_recognition
import sys


def save_face_camera(tel):
    vc = cv2.VideoCapture(0, cv2.CAP_DSHOW)
    vc.set(3, 640)
    vc.set(4, 480)
    # Video
    while True:
        ret, video = vc.read()
        vc_img = vc.read()[1]
        if not ret:
            print("No video!\n")
            break
        # Trans
        video = cv2.cvtColor(video, cv2.COLOR_BGR2GRAY)
        # Locate and draw lines
        vc_locations = face_recognition.face_locations(video, number_of_times_to_upsample=1, model="hog")
        for top, right, bottom, left in vc_locations:
            cv2.rectangle(video, (left, top), (right, bottom), (0, 0, 255), 3)
        # Show video
        cv2.imshow("Camera", video)
        # Key events
        if cv2.waitKey(1) == 13 and len(vc_locations) > 0:
            print(vc_locations)
            cv2.imwrite("img\\" + tel + ".png", vc_img)
            break
        if cv2.waitKey(1) == ord('q'):
            break
        if cv2.getWindowProperty('Camera', cv2.WND_PROP_AUTOSIZE) < 1:
            break
    vc.release()
    cv2.destroyAllWindows()


save_face_camera(sys.argv[1])
