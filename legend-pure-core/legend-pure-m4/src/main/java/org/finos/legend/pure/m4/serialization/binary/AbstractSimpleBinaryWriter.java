// Copyright 2023 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.pure.m4.serialization.binary;

import java.nio.ByteBuffer;

public abstract class AbstractSimpleBinaryWriter extends AbstractBinaryWriter
{
    private final byte[] bytes = new byte[Math.max(Long.BYTES, Double.BYTES)];
    private final ByteBuffer byteBuffer = ByteBuffer.wrap(this.bytes);

    @Override
    public synchronized void writeShort(short s)
    {
        this.byteBuffer.putShort(0, s);
        writeBytes(this.bytes, 0, Short.BYTES);
    }

    @Override
    public synchronized void writeInt(int i)
    {
        this.byteBuffer.putInt(0, i);
        writeBytes(this.bytes, 0, Integer.BYTES);
    }

    @Override
    public synchronized void writeLong(long l)
    {
        this.byteBuffer.putLong(0, l);
        writeBytes(this.bytes, 0, Long.BYTES);
    }

    @Override
    public synchronized void writeFloat(float f)
    {
        this.byteBuffer.putFloat(0, f);
        writeBytes(this.bytes, 0, Float.BYTES);
    }

    @Override
    public synchronized void writeDouble(double d)
    {
        this.byteBuffer.putDouble(0, d);
        writeBytes(this.bytes, 0, Double.BYTES);
    }
}
