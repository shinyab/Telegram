package net.bluehack.messenger.exoplayer.extractor.ogg;

import net.bluehack.messenger.exoplayer.extractor.ExtractorInput;
import net.bluehack.messenger.exoplayer.extractor.ExtractorOutput;
import net.bluehack.messenger.exoplayer.extractor.PositionHolder;
import net.bluehack.messenger.exoplayer.extractor.TrackOutput;
import net.bluehack.messenger.exoplayer.util.ParsableByteArray;
import java.io.IOException;

/**
 * StreamReader abstract class.
 */
/* package */ abstract class StreamReader {

  protected final ParsableByteArray scratch = new ParsableByteArray(
      new byte[OggParser.OGG_MAX_SEGMENT_SIZE * 255], 0);

  protected final OggParser oggParser = new OggParser();

  protected TrackOutput trackOutput;

  protected ExtractorOutput extractorOutput;

  void init(ExtractorOutput output, TrackOutput trackOutput) {
    this.extractorOutput = output;
    this.trackOutput = trackOutput;
  }

  /**
   * @see Extractor#seek()
   */
  void seek() {
    oggParser.reset();
    scratch.reset();
  }

  /**
   * @see Extractor#read(ExtractorInput, PositionHolder)
   */
  abstract int read(ExtractorInput input, PositionHolder seekPosition)
      throws IOException, InterruptedException;
}
