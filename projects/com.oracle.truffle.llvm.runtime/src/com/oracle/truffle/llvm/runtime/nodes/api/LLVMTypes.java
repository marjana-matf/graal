/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.truffle.llvm.runtime.nodes.api;

import com.oracle.truffle.api.dsl.TypeCast;
import com.oracle.truffle.api.dsl.TypeCheck;
import com.oracle.truffle.api.dsl.TypeSystem;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.llvm.runtime.LLVMFunctionDescriptor;
import com.oracle.truffle.llvm.runtime.LLVMIVarBit;
import com.oracle.truffle.llvm.runtime.LLVMTruffleObject;
import com.oracle.truffle.llvm.runtime.floating.LLVM80BitFloat;
import com.oracle.truffle.llvm.runtime.pointer.LLVMManagedPointer;
import com.oracle.truffle.llvm.runtime.pointer.LLVMNativePointer;
import com.oracle.truffle.llvm.runtime.pointer.LLVMPointer;
import com.oracle.truffle.llvm.runtime.vector.LLVMDoubleVector;
import com.oracle.truffle.llvm.runtime.vector.LLVMFloatVector;
import com.oracle.truffle.llvm.runtime.vector.LLVMI16Vector;
import com.oracle.truffle.llvm.runtime.vector.LLVMI1Vector;
import com.oracle.truffle.llvm.runtime.vector.LLVMI32Vector;
import com.oracle.truffle.llvm.runtime.vector.LLVMI64Vector;
import com.oracle.truffle.llvm.runtime.vector.LLVMI8Vector;

@TypeSystem({boolean.class, byte.class, short.class, int.class, char.class, long.class, double.class, float.class, byte[].class, LLVMI8Vector.class, LLVMI64Vector.class, LLVMI32Vector.class,
                LLVMI1Vector.class, LLVMI16Vector.class, LLVMFloatVector.class, LLVMDoubleVector.class, LLVMIVarBit.class,
                LLVMNativePointer.class,
                LLVMManagedPointer.class,
                LLVMPointer.class,
                LLVMTruffleObject.class,
                LLVM80BitFloat.class,
                LLVMFunctionDescriptor.class,
                TruffleObject.class})
public class LLVMTypes {

    @TypeCheck(LLVMPointer.class)
    public static boolean isPointer(Object object) {
        return LLVMPointer.isInstance(object);
    }

    @TypeCast(LLVMPointer.class)
    public static LLVMPointer asPointer(Object object) {
        return LLVMPointer.cast(object);
    }

    @TypeCheck(LLVMNativePointer.class)
    public static boolean isNativePointer(Object object) {
        return LLVMNativePointer.isInstance(object);
    }

    @TypeCast(LLVMNativePointer.class)
    public static LLVMNativePointer asNativePointer(Object object) {
        return LLVMNativePointer.cast(object);
    }

    @TypeCheck(LLVMManagedPointer.class)
    public static boolean isManagedPointer(Object object) {
        return LLVMManagedPointer.isInstance(object);
    }

    @TypeCast(LLVMManagedPointer.class)
    public static LLVMManagedPointer asManagedPointer(Object object) {
        return LLVMManagedPointer.cast(object);
    }
}
