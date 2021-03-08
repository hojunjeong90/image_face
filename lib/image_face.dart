import 'dart:async';
import 'dart:io';

import 'package:flutter/services.dart';

/// ImageFace class the namespace of this lib
class ImageFace {
  /// method channel for image face
  static const MethodChannel _channel = const MethodChannel('image_face');

  /// check the image has face
  static Future<int> hasFace(File image) async {
    if (image == null) {
      // if the file is null it is no face
      return 0;
    }

    /// image path
    final Map<String, String> arg = {'image': image.path};

    /// incoke native method
    var _has = await _channel.invokeMethod('hasFace', arg);
    // return result
    return _has;
  }
}
