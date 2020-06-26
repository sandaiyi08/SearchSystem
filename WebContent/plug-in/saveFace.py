import cv2
import face_recognition
import sys


def save_face(imgPath):
    fr_img = face_recognition.load_image_file(imgPath)
    fr_face_location = face_recognition.face_locations(fr_img, number_of_times_to_upsample=2, model="hog")
    if len(fr_face_location) > 0:
        print(fr_face_location)


save_face(sys.argv[1])
