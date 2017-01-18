// Generated by CoffeeScript 1.9.1
(function() {
  var JSOG, JSOG_OBJECT_ID, hasCustomJsonificaiton, isArray, nextId;

  JSOG = {};

  nextId = 0;

  isArray = Array.isArray || function(obj) {
    return Object.prototype.toString.call(obj) === '[object Array]';
  };

  hasCustomJsonificaiton = function(obj) {
    return obj.toJSON != null;
  };

  JSOG_OBJECT_ID = '__jsogObjectId';

  JSOG.encode = function(original) {
    var doEncode, idOf, sofar;
    sofar = {};
    idOf = function(obj) {
      if (!obj[JSOG_OBJECT_ID]) {
        obj[JSOG_OBJECT_ID] = "" + (nextId++);
      }
      return obj[JSOG_OBJECT_ID];
    };
    doEncode = function(original) {
      var encodeArray, encodeObject;
      encodeObject = function(original) {
        var id, key, result, value;
        id = idOf(original);
        if (sofar[id]) {
          return {
            '@ref': id
          };
        }
        result = sofar[id] = {
          '@id': id
        };
        for (key in original) {
          value = original[key];
          if (key !== JSOG_OBJECT_ID) {
            result[key] = doEncode(value);
          }
        }
        return result;
      };
      encodeArray = function(original) {
        var val;
        return (function() {
          var i, len, results;
          results = [];
          for (i = 0, len = original.length; i < len; i++) {
            val = original[i];
            results.push(doEncode(val));
          }
          return results;
        })();
      };
      if (original == null) {
        return original;
      } else if (hasCustomJsonificaiton(original)) {
        return original;
      } else if (isArray(original)) {
        return encodeArray(original);
      } else if (typeof original === 'object') {
        return encodeObject(original);
      } else {
        return original;
      }
    };
    return doEncode(original);
  };

  JSOG.decode = function(encoded) {
    var doDecode, found;
    found = {};
    doDecode = function(encoded) {
      var decodeArray, decodeObject;
      decodeObject = function(encoded) {
        var id, key, ref, result, value;
        ref = encoded['@ref'];
        if (ref != null) {
          ref = ref.toString();
        }
        if (ref != null) {
          return found[ref];
        }
        result = {};
        id = encoded['@id'];
        if (id != null) {
          id = id.toString();
        }
        if (id) {
          found[id] = result;
        }
        for (key in encoded) {
          value = encoded[key];
          if (key !== '@id') {
            result[key] = doDecode(value);
          }
        }
        return result;
      };
      decodeArray = function(encoded) {
        var value;
        return (function() {
          var i, len, results;
          results = [];
          for (i = 0, len = encoded.length; i < len; i++) {
            value = encoded[i];
            results.push(doDecode(value));
          }
          return results;
        })();
      };
      if (encoded == null) {
        return encoded;
      } else if (isArray(encoded)) {
        return decodeArray(encoded);
      } else if (typeof encoded === 'object') {
        return decodeObject(encoded);
      } else {
        return encoded;
      }
    };
    return doDecode(encoded);
  };

  JSOG.stringify = function(obj) {
    return JSON.stringify(JSOG.encode(obj));
  };

  JSOG.parse = function(str) {
    return JSOG.decode(JSON.parse(str));
  };

  if ((typeof module !== "undefined" && module !== null) && module.exports) {
    module.exports = JSOG;
  }

  if (typeof window !== "undefined" && window !== null) {
    window.JSOG = JSOG;
  }

  if (typeof define === 'function' && define.amd) {
    define('JSOG', [], function() {
      return JSOG;
    });
  }

  return JSOG;

}).call(this);
